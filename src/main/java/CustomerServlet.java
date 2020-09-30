import Constructors.Customer;
import Exceptions.EntityNotFoundException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet class
 * Uses doGet() and gets a customer name from the URL, it will use DataStore class to deliver that customers information.
 */
public class CustomerServlet extends HttpServlet {
    /**
     * Checks if customers name exists if not it will throw 'HTTP ERROR 404 Not Found'
     *  @param request HttpServletRequest object
     *  @param response HttpServletResponse object
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Customer customer = null;
        String requestUrl = request.getRequestURI();
        String name = requestUrl.substring("/GojiMicroserviceExercise/customer/".length());
        // Here we use the getInstance to find the customers name from the constructor in DataStore.
        try {
            customer = DataStore.getInstance().getCustomer(name);
        } catch (EntityNotFoundException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        // Checks if customer object is not null, if so it will then return a JSON as the response to the get request.
        // I would most definitely changed this JSON format to something more robust.
        if (customer != null) {
            String json = "{\n";
            json += "\"name\": " + JSONObject.quote(customer.getName()) + ",\n";
            json += "\"callback\": " + JSONObject.quote(customer.getCallback()) + ",\n";
            json += "}";
            response.getOutputStream().println(json);
        }
    }

    /**
     * Will POST the customers info as a JSON onto the web server if successful.
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        String callback = request.getParameter("callback");

        DataStore.getInstance().putCustomer(new Customer(name, callback));
    }
}
