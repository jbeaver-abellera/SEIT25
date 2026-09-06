package io.cucumber.data;

import java.util.List;

public class Data {

    public static final List<String> ExpectedAvailableExamples = List.of(
            "A/B Testing",
            "Add/Remove Elements",
            "Basic Auth (user and pass: admin)",
            "Broken Images",
            "Challenging DOM",
            "Context Menu",
            "Digest Authentication (user and pass: admin)",
            "Disappearing Elements",
            "Drag and Drop",
            "Dropdown",
            "Dynamic Content",
            "Dynamic Controls",
            "Dynamic Loading",
            "Entry Ad",
            "Exit Intent",
            "File Download",
            "File Upload",
            "Floating Menu",
            "Forgot Password",
            "Form Authentication",
            "Geolocation",
            "Horizontal Slider",
            "Infinite Scroll",
            "Inputs",
            "JavaScript Alerts",
            "JavaScript onload event error",
            "Key Presses",
            "Large & Deep DOM",
            "Multiple Windows",
            "Nested Frames",
            "Notification Messages",
            "Redirect Link",
            "Secure File Download",
            "Shadow DOM",
            "Shifting Content",
            "Slow Resources",
            "Sortable Data Tables",
            "Status Codes",
            "Typos",
            "WYSIWYG Editor"
    );

    public static final List<List<String>> ExpectedTable1 = List.of(
            List.of("Last Name", "First Name", "Email", "Due", "Web Site"),
            List.of("Smith",    "John",  "jsmith@gmail.com",        "$50.00", "http://www.jsmith.com"),
            List.of("Bach",     "Frank", "fbach@yahoo.com",         "$51.00", "http://www.frank.com"),
            List.of("Doe",      "Jason",  "jdoe@hotmail.com",        "$100.00", "http://www.jdoe.com"),
            List.of("Conway",   "Tim",   "tconway@earthlink.net",   "$50.00", "http://www.timconway.com")
    );

}