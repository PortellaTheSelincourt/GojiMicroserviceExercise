# README #

Guide

This is a Java coding exercise.

You should take no more than a few hours to complete it. If you take longer, you are probably
going further than you need to! Please don’t turn this into a huge project.

We know it’s hard to fit these things in around a full-time job, so you have one week to submit your
solution. If you need longer, please get in touch.

When you’re done, push the code to a private GitHub repository, and add @gojitechteam as a
collaborator. That will send us a notification to go and review your code.

We will discuss your solution further with you via a Zoom call if you pass this stage.

Requirements

For this exercise, you must create a small, simple Java microservice which acts as a
subscription-based clock.

It should allow clients to register a callback URL at any time and then receive notifications of the
time of day at regular intervals as a webhook until they unregister the URL.

It must provide three endpoints, adhering to RESTful conventions. These should allow the client to:

● Register: provide a URL to which the time should be sent. Should error if the client URL is
already registered for callbacks

● Deregister: stop receiving the time at the specified URL. Should error if the client URL is
not registered for callbacks

● Change the frequency of callbacks for a URL, to any time between 5 seconds and 4 hours.
The application should continuously POST the time to all registered URLs at the frequency
requested.

Additional notes:

● Use either Maven or Gradle to build, and run a small number of suitable automated tests as
part of the build. The build should produce a standalone, runnable JAR.

● All endpoints and the webhooks should use JSON for the message body, if there is one.

● For simplicity, assume that there will only be one instance of the application, and there will
be no persistent database. Store state in memory only.

● Don’t worry about running out of memory, but beyond that, your solution should be
designed to handle lots of concurrent requests and lots of active webhooks without risk of
data loss or crashing.

● Feel free to use application frameworks as you see fit. However, do not use Spring Data
or similar layers which auto-generate data store code, or in-memory databases such as H2. Please implement your in-memory data store yourself.

● Don't worry about any security issues such as authentication or SSL.

You are free to interpret the rest of the brief as you see fit.

You won't be able to cover everything in just a few hours, so keep it simple, stick to conventions,
and think about what you didn't have time for. You are encouraged to use in-code comments to
indicate areas you think are incomplete or in need of improvement.

Advice to read before starting and sumbitting the test:

- Stick to the requirements, many people so far have fell down on not following the requirements of the test, so keep these at the front of your
mind throughout!!! IF you don’t you WILL NOT pass this stage.
- Keep your solution very simple and easy to read. Do NOT over-engineer or over-complicate your solution
- Do NOT put everything in one class!!!
- Show good test coverage and make sure it is well tested
- Make sure you show good documentation
- As you move through your solution, make notes on how you would extend/refactor or add more features if you had more time, this will give you a
great blue print for the next round in the process which is a test review