# ContactList
A Simple Android Contact List that simulates interaction with an API.

![alt text](https://raw.githubusercontent.com/jugutier/contactlist/master/screenshots/1.png)
![alt text](https://raw.githubusercontent.com/jugutier/contactlist/master/screenshots/2.png)
## Key Features

	1.	Displays sample data coming from a local JSON File
	2.	Uses Android's Recycler View.  
	  a.	Display views that show the person's picture (on the left), name (as the title), and position (as the subtitle). This is done using an ArrayAdapter.
	  b.	Load the images asynchronously so UI is not blocked while waiting for downloads.
	  c.	When a row is clicked, it takes you to a detail view that display the contact details (picture, name, and position, similarly to the OS contacts app) a fade in transition to that view is added.
## Design decisions
 - minSdk is 19 and target is 25 to cover 80% of the current market.
 - Glide is used to fetch images from the network but it is abstracted in the `NetworkImage` class to prevent logic to rely on a specific library.
 - Repositories are modeled after data that comes from a local JSON file which is parsed using Google's GSON library. 
 Again this implementation detail is abstracted from that layer so that changing this to grab a longer list from an API endpoint would be little to no effort.
## Tests
This project provides both **Instrumentation** and **Unit** tests to showcase both in the context of Android Development.
