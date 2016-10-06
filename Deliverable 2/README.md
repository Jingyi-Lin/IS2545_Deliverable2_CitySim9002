# IS2545 - DELIVERABLE 2: Unit Testing

At the beginning of doing this assignment, I met a problem of designing how to divide classes for better presenting the logic. I read the requirement carefully and tried to find out a solution. Later, besides main class, I decided to have classes for generate visitors, generate locations and a random number generator.

For the testing part, I used mocks, doubles and stubs to generate the unit tests for each public method. I generated 14 test cases in total, covering the test of argument, generating visitors and locations, and the whole program performance. They have no errors and all passed.

When I trying to do the test, one problem I met was I have no idea how to test "The visitor cannot leave the city in the first iteration". I found I have no method to check the first generated location, instead, I just use a while loop to check whether the location generated is "left" or not. In order to write the test by calling a proper method, I think I should use better coding methods. Then I modified my while loop to a more proper method called firstVisit, so that I can use this method to generate tests.
