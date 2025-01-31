package com.hszg.demo;

import com.hszg.demo.data.api.TaskManager;
import com.hszg.demo.data.impl.PostgresTaskManagerImpl;
import com.hszg.demo.data.impl.PropertyFileTaskManagerImpl;
import com.hszg.demo.model.alexa.AlexaRO;
import com.hszg.demo.model.alexa.OutputSpeechRO;
import com.hszg.demo.model.alexa.ResponseRO;
import com.hszg.demo.model.exampleanswer.ExampleAnswer;
import com.hszg.demo.model.examplestudent.ExampleStudent;
import com.hszg.demo.model.student.Student;
import com.hszg.demo.model.task.MessageAnswer;
import com.hszg.demo.model.task.Task;
import com.hszg.demo.model.task.TokenTask;
import com.hszg.demo.model.tripadvisor.TokenClass;
import com.hszg.demo.model.tripadvisor.auth.CreateAuthIn;
import com.hszg.demo.model.tripadvisor.location.CommentLocationIn;
import com.hszg.demo.model.tripadvisor.location.locationGET.Comment;
import com.hszg.demo.model.tripadvisor.location.locationGET.LocInfoLocationOut;
import com.hszg.demo.model.tripadvisor.location.locationPOST.Address;
import com.hszg.demo.model.tripadvisor.location.locationPOST.CreateLocationIn;
import com.hszg.demo.model.tripadvisor.messages.Message;
import com.hszg.demo.model.tripadvisor.messages.MessageWithUsername;
import com.hszg.demo.model.tripadvisor.messages.UpdateWithToken;
import com.hszg.demo.model.tripadvisor.user.UserDataOut;
import com.hszg.demo.model.tripadvisor.user.CreateUserIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MappingController {


    TaskManager propertyFileTaskManager =
            PropertyFileTaskManagerImpl.getPropertyFileTaskManagerImpl("src/main/resources/TaskList.properties");


    // Auth ----------------------------------

    @PostMapping(
            path = "/auth",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public TokenClass loginUser(@RequestBody CreateAuthIn authIn) {

        Logger myLogger = Logger.getLogger("LogIn");
        myLogger.info(
                "User " + authIn.getUsername() + " tried to log in with password " + authIn.getPassword()
        );

        // TODO: Create new token, save it to database and return it.

        TokenClass tokenClass = new TokenClass();
        tokenClass.setToken("");

        return tokenClass;
    }

    @DeleteMapping(
            path = "/auth",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public void logoutUser(@RequestBody TokenClass tokenClass) {

        Logger myLogger = Logger.getLogger("LogIn");
        myLogger.info(
                "User with token " + tokenClass.getToken() + " tried to log out"
        );

        // TODO: Delete token from database
    }


    // User ----------------------------------

    @PostMapping(
            path = "/user",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public MessageWithUsername createUser(@RequestBody CreateUserIn userIn) {

        Logger myLogger = Logger.getLogger("CreateUser");
        myLogger.info(
                "Tried to create a new user with the following properties:\n"
                        + "Email: " + userIn.getUsername()
                        + ", FirstName: " + userIn.getFirstName()
                        + ", LastName: " + userIn.getLastName()
                        + ", Username: " + userIn.getUsername()
                        + ", Password: " + userIn.getPasswort()
        );

        // TODO: Save new user in database if possible; send error message if not possible
        //  Save username (from database) in variable username

        String username = "";

        String message = "User created successfully";

        MessageWithUsername messageWithUsername = new MessageWithUsername();
        messageWithUsername.setUsername(username);
        messageWithUsername.setMessage(message);

        return messageWithUsername;
    }


    @DeleteMapping(
            path = "/user",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public MessageWithUsername deleteUser(@RequestBody TokenClass tokenClass) {

        Logger myLogger = Logger.getLogger("DeleteUser");
        myLogger.info(
                "User with token" + tokenClass.getToken() + " tried to be deleted"
        );

        // TODO:
        //  Get belonging user of token
        //  Delete that user from database if possible

        String username = "";

        String message = "User deleted successfully";

        MessageWithUsername messageWithUsername = new MessageWithUsername();
        messageWithUsername.setUsername(username);
        messageWithUsername.setMessage(message);

        return messageWithUsername;
    }


    @GetMapping(
            path = "/user",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public UserDataOut getUserInfo(@RequestBody TokenClass tokenClass) {

        Logger myLogger = Logger.getLogger("GetUserInfo");
        myLogger.info(
                "User with token" + tokenClass.getToken() + " tried to be deleted"
        );

        // TODO:
        //  Get belonging user of token
        //  Get infos from database

        String email = "";
        String username = "";
        String firstName = "";
        String lastName = "";

        UserDataOut userDataOut = new UserDataOut();
        userDataOut.setEMail(email);
        userDataOut.setUsername(username);
        userDataOut.setFirstName(firstName);
        userDataOut.setLastName(lastName);

        return userDataOut;
    }


    @PutMapping(
            path = "/user",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Message updateUser(@RequestBody UpdateWithToken updateWithToken) {

        Logger myLogger = Logger.getLogger("UpdateUser");
        myLogger.info(
                "User with token" + updateWithToken.getToken()
                        + " tried to update field: " + updateWithToken.getFieledToBeChanged()
                        + " with value " + updateWithToken.getValue()
        );

        // TODO:
        //  Get belonging user of token
        //  Update database

        String message = "";

        Message messageOut = new Message();
        messageOut.setMessage(message);

        return messageOut;
    }



    // Location ----------------------------------

    @GetMapping(
            path = "/location",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public LocInfoLocationOut getLocationInformation(@RequestBody TokenClass tokenClass) {

        Logger myLogger = Logger.getLogger("GetLocationInformation");
        myLogger.info(
                "User with token" + tokenClass.getToken()
                        + " tried to get infos of location"
        );

        // TODO:
        //  Get belonging user of token
        //  !!Change Comments into List<String> in class "LocInfoLocationOut"!!
        //  Get Location from database

        String locationName = "";
        String locationCategory = "";

        Address locationAddress = new Address();
        String country = "";
        String street = "";
        String city = "";
        locationAddress.setCountry(country);
        locationAddress.setStreet(street);
        locationAddress.setCity(city);

        String locationDescription = "";
        String locationRating = "";

        List<Comment> comments = new ArrayList<>();
        List<String> pictures = new ArrayList<>();
        List<String> tags = new ArrayList<>();

        LocInfoLocationOut locationInformation = new LocInfoLocationOut();
        locationInformation.setName(locationName);
        locationInformation.setCategory(locationCategory);
        locationInformation.setAddress(locationAddress);
        locationInformation.setDescription(locationDescription);
        locationInformation.setRating(locationRating);
        locationInformation.setPictures(pictures);
        locationInformation.setTags(tags);

        return locationInformation;
    }

    @PostMapping(
            path = "/location",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Message createLocation(@RequestBody CreateLocationIn locationIn) {

        Logger myLogger = Logger.getLogger("CreateLocation");
        myLogger.info(
                "Tried to create location with properties:\n"
                + " Name " + locationIn.getName()
                + " Category " + locationIn.getCategory()
                + " Address " + locationIn.getAddress()
                + " Description " + locationIn.getDescription()
        );

        // TODO:
        //  Insert new location into database

        String message = "";

        Message messageOut = new Message();
        messageOut.setMessage(message);

        return messageOut;
    }

    @DeleteMapping(
            path = "/location",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Message deleteLocation(@RequestBody TokenClass tokenClass) {

        Logger myLogger = Logger.getLogger("DeleteLocation");
        myLogger.info(
                "User with token" + tokenClass.getToken() + " tried to delete location"
        );

        // TODO:
        //  Insert new location into database

        String message = "";

        Message messageOut = new Message();
        messageOut.setMessage(message);

        return messageOut;
    }

    @PutMapping(
            path = "/edit-location",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Message editLocation(@RequestBody UpdateWithToken updateWithToken) {

        Logger myLogger = Logger.getLogger("EditLocation");
        myLogger.info(
                "User with token" + updateWithToken.getToken()
                + " tried to update field: " + updateWithToken.getFieledToBeChanged()
                + " with value " + updateWithToken.getValue()
        );

        // TODO:
        //  Check if token exists
        //  Update location in database

        String message = "";

        Message messageOut = new Message();
        messageOut.setMessage(message);

        return messageOut;
    }

    @PutMapping(
            path = "/comment-location",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Message editLocation(@RequestBody CommentLocationIn commentLocationIn) {

        Logger myLogger = Logger.getLogger("CommentLocation");
        myLogger.info(
                "User with token" + commentLocationIn.getToken()
                        + "tried to comment location " + commentLocationIn.getName()
                        + " with comment " + commentLocationIn.getComment()
                        + " and rating " + commentLocationIn.getRating()
        );

        // TODO:
        //  Get belonging user of token
        //  Add comment in database

        String message = "";

        Message messageOut = new Message();
        messageOut.setMessage(message);

        return messageOut;
    }


    // -------------------------------------------------------------------------------------------

    @PostMapping(
            path = "/hszg-tasks",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public MessageAnswer createTask(@RequestBody TokenTask tokenTask) {

        Logger myLogger = Logger.getLogger("CreateTaskLogger");
        myLogger.info("Received a POST request on hszg-tasks with token " + tokenTask.getToken());

        String token = tokenTask.getToken();
        String name = tokenTask.getTask().getName();
        MessageAnswer myAnswer = new MessageAnswer();
        myAnswer.setMessage("Taskname " + name + " with token " + token);

        Student tempStudent = new Student("Tom", "Tom");
        propertyFileTaskManager.addTask(tokenTask.getTask(), tempStudent);

        return
                myAnswer;
    }



    @PostMapping(
            path = "/alexa",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public AlexaRO createTask(@RequestBody AlexaRO alexaRO) {

        String myAnswer = "";
        if (alexaRO.getRequest().getIntent().getName().equals("TaskReadIntent")) {
            myAnswer += "You have to do the following tasks: ";
            myAnswer += "1. Learn for the math exam.";
            myAnswer += "2. Buy milk for mom.";
            myAnswer += "3. Continue my work for web engineering.";
        }
        else {
            myAnswer += "I do not know what to say.";
        }

        return
                prepareResponse(alexaRO, myAnswer, true);
    }

    @PostMapping(
            path = "/students",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public ExampleAnswer createStudent(@RequestBody ExampleStudent exampleStudent) {
        String email = exampleStudent.getEmail();
        String message = "User Created";

        return new ExampleAnswer(email, message);
    }




    @GetMapping("/hszg-tasks")
    public List<Task> getTasks(@RequestParam(value = "email", defaultValue = "email") String email,
                             @RequestParam(value = "token", defaultValue = "123") String token) {

        Logger myLogger = Logger.getLogger("GetTaskLogger");
        myLogger.info("Received a GET request on hszg-tasks with token " + token);

        // TODO
        //  check token
        //  TokenManager

        final List<Task> allTasks = propertyFileTaskManager.getAllTasks(email);

        return allTasks;
    }




    @PostMapping(
            path = "/task/createtable"
    )
    @ResponseStatus(HttpStatus.OK)
    public String createTask() {

        final PostgresTaskManagerImpl postgresTaskManagerImpl =
                PostgresTaskManagerImpl.getPostgresTaskManagerImpl();
        postgresTaskManagerImpl.createTableTask();

        return "Database Table created";
    }



    @PostMapping(
            path = "/alexa",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public AlexaRO getTasks(@RequestBody AlexaRO alexaRO) {

        // TODO
        String outText = "";


        return alexaRO;
    }

    private AlexaRO prepareResponse(AlexaRO alexaRO, String outText, boolean shouldEndSession) {

        alexaRO.setRequest(null);
        alexaRO.setSession(null);
        alexaRO.setContext(null);
        OutputSpeechRO outputSpeechRO = new OutputSpeechRO();
        outputSpeechRO.setType("PlainText");
        outputSpeechRO.setText(outText);
        ResponseRO response = new ResponseRO(outputSpeechRO, shouldEndSession);
        alexaRO.setResponse(response);
        return alexaRO;
    }

}
