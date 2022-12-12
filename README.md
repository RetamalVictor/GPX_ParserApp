# Software Design 
This is the template for the team project of the Software Design course at the Vrije Universiteit Amsterdam. 

## Introduction

*Author(s): Bas Dijkstra

**The GPXManager** is a tool used to visualize sport activities. The aim of this tool is to give the user better insight into their sports achievements. This can be done by turning data in GPX format into visual data on a map. GPX is a standard data format used by popular sport tracking apps such as Strava, Runkeeper etc. More info on the GPX data format can be found [here](https://en.wikipedia.org/wiki/GPS_Exchange_Format).
This manager uses the GPX data to give the user the option to compute some basic metrics on said data. This includes total travelled distance, min-max altitude, estimated number of burned calories etc.
All these visualizations and calculations can be done on any performed sport, giving the user a wide variety of uses for this manager.


**The main type of user:**
- User: A user who uploads their GPX data and uses the manager to visualize this data.

The sports targeted in the app are those route dependent, such as running, cycling or outdoor swimming 

**The manager shall work as follows:**
1. The user uses the button to upload their data into the manager.
2. The manager displays the route of the data on a map and gives the user the option to perform some basic metrics on the data.
3. The manager displays metrics calculated from the GPX file on the screen. 
4. The user selects the sport performed from a list of sports in the manager.
5. When the user clicks the button to go back to the main menu, the main menu is displayed again, and the user has the option to upload a new GPX file.
6. When the user clicks the button to close the manager, the manager is closed.


##  Features

*Author(s): Victor Retamal Guiberteau


### Functional features

The software will have an initial UI with the option to load a GPX file. We decided to utilize the UI instead of command lines to facilitate the interaction with the software. 
The first required action will be to input a GPX file. The data from the file will be parsed and loaded to calculate the metrics and the track point that will be displayed. 
These two actions will be triggered after the input of the data. The main idea behind this is to avoid extra steps for the user to get the functionality of the software. 


| **ID**  | **Short name**                   | **Description**| **Champion**       |
|-----|------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------|
| F1  | Commands                     | On the main screen of the software, the user will have the option to activate the following function: <br>- Load GPX <br>- Back button to load other GPX file<br> Once a GPX file is loaded, two functions will trigger: <br>- Calculate metrics <br>- Display data in the map <br>After the triggered actions: <br>- Assign a sport <br>- Save report                  | Bas Dijkstra   |
| F2  | GPX file handling            | The GPX file will be loaded and the data will be ready to be read by the other functions.  It will generate an object with the possibility to add more information as a sport.  After loading, the GPX file will be parsed and the data extracted to calculate the metrics and display the route in the map The file extension is .gpx  | Victor         |
| F3  | Sports Assignment            | A list of sports will be displayed to the user.  Each sport will have a set of extra metrics related to the sport.                                                                                                                                                                                                                      | Daniel         |
| F4  | Display GPX data on map      | The GPX route should be displayed on the map with the right coordinates. Two Checkpoints will be displayed. One checkpoint at the beginning and the other at the end of the route.                                                                                                                                                      | Daniel         |
| F5  | Calculate Basic metrics      | Calculate distance travelled, time taken to complete the route, elevation difference, average speed and top speed during the route.                                                                                                                                                                                                     | Krasen Todorov |
| F6  | Save Report                  | Save a snapshot of the report to pdf or png with the map information and the metrics.                                                                                                                                                                                                                                                   | Victor         |
| BF7 | Zoom in the map              | (BONUS) The user may zoom in and zoom out of the map to visualize specific parts of the route                                                                                                                                                                                                                                           | Krasen         |
| BF8 | Add Mark points and comments | (BONUS) The user may add mark points in the map and attach comments to it. These comments will be displayed on the side of the map and when the mouse is on the mark point                                                                                                                                                              | Daniel         |

##  Quality requirements

*Author(s): Krasen Todorov

| **ID**   | **Short name**                                      | **Quality attribute** | **Description**                                                                                                                                                                                                   |
|------|-------------------------------------------------|-------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| QR1  | Adding categories                               | Maintainability   | The list of sports can be extended for further versions and updates of the product.                                                                                                                           |
| QR2  | Return to home screen/ Back button              | Usability         | The option of returning to the home screen and uploading a new data file needs to be available for the user via a button.                                                                                     |
| QR3  | Speed of loading and visualizing GPX data files | Responsiveness    | The data file needs to be visualized as a GPX route on the map with the specific coordinates within 1s after it has been uploaded.                                                                            |
| QR4  | Extension of downloadable files                 | Availability      | The visual report should be of an accessible document file extension such as .pdf or .png.                                                                                                                    |
| QR5  | User interface simplicity                       | Usability         | The user interface needs to follow a simplified design: a call to action button needs to be assigned for each one of the main functions: Uploading a GPX file, selecting a sport and calculating the metrics. |
| QR6  | Required data                                   | Security          | The system should not require any SPI (sensitive personal information) from users in order for them to access its features for security reasons.                                                              |
| BQR7 | BONUS/Encryption                                | Security          | The saved file is to be encrypted with Base64 encoding to prevent data leaks.                                                                                                                                 |
| BQR8 | BONUS/ Metric systems                           | Usability         | The computed metrics need to be displayed in both metric systems - the International System of Units and the United States customary units.                                                                   |

##  Features

*Author(s): Daniel R.

**[GMapsFX](https://github.com/dlsc-software-consulting-gmbh/GMapsFX)**
Used to visualize the imported GPX data and visualize it on the Google maps API.

This library allows the GPX data to be displayed on a readable Google maps background, making the end product, which is the PDF or PNG file with a map, visually pleasing for the end-user.


**[JavaFX](https://openjfx.io/)**
Used to visualize interactable UI.

This library will allow the program to have an interactable UI for the user to import the GPX data and select a sport are some examples. This UI was chosen because of its simplicity and is easier to implement compared to other UI libraries which the team may not be familiar with.


**[Apache PDFBox](https://pdfbox.apache.org/)**
Used to generate a printable visual PDF report of the end product made by the GPXmanager.

This library will aid in the generating of an end report PDF file for all the GPX data and maps. The library was chosen because it gives the development team options on how to save and/or print the end-report of the GPXmanager. Such as, the library allows the pasting of images into the PDF which would aid in adding the map into the end-report.

**[Xchart (Optional)](https://github.com/knowm/XChart)**
Used to generate and visualize a 2D graph of the GPX data.

This library will allow the plotting of the GPX data on a 2D Graph for certain features. Such as, the altitude walked or calories burnt over time are some examples. But because those features are currently listed as bonus features the use of this library is optional.


