# swapi-app

A litte SWAPI-App to search for Star Wars things!
This is my submission for the coding challenge from TGR.

## General thoughts

I chose an application with backend, because I am very familiar with this area. This has several advantages. I was able to reduce the request times by the caching layer of the server and also prepare the data in the server. The results provide a good UX.
For the frontend I decided to use Angular. Not only it was requested in the job vacancy as well as in the coding challenge, it also allows me to prove my thesis that the switch will be easy for me due to my years of experience with Vue.js. So this is the first time I have worked with Angular.
I am well aware that the application still has room for optimization. Considering the approximate time frame of three hours, I think my result is very good.
On top of that, I have deployed the application to my private environment and it can be accessed via https://swapi.lkaktus23.de/. I developed the deployment pipeline with GitHub actions. Please note that the Docker environment is my private playground, which I mainly use for experimenting with other technologies.
It took me about 10-11 hours to finish everything. This also includes dealing with a new framework and the deployment pipeline. I would be incredibly happy if we could exchange ideas about my result in person.

## Frontend

As mentioned before, this is my first Angular project. However, most of the functionality looks familiar to me through Vue.js. I decided to create only two "pages". On the start page you can search for the Star Wars terms. On the details page you can see the properties of your search and either start a new search with the link "Start new search" or look at more details with the links in the properties (for example details about the homeworld of a character). I generally went with a more end-user oriented UI, which is why I focused on smartphone displays.
To provide a good user interface, I chose an input on the start page, which returns results after entering two characters below. The input works well on desktop PCs and on smartphones.
A loading bar also gives the user feedback about the background processes.
On the details page, the focus on smartphone displays is clear. The properties are arranged in a table, with one column containing the table headings and the other the value. Here you could optimize the display for desktops by setting up the table differently, for example by having the first table row contain the headings.
Unfortunately, there are no error pages at all for different error codes. These could be displayed via the Angular router, for example, by forwarding to the error page when errors occur. There, the error could be identified and the page could be filled with details.

## Backend

For the backend, I decided to use Springboot and Java, as I currently have the most experience with them. The backend also serves to improve the UX, since I can reduce the request times through the caching layer. In addition, I can prepare the data here the way the frontend needs it and bundle the different requests needed to the Swapi API. The data preparation could be optimized in any case by separating the DTOs for the frontend and for the Swapi-Api. Also the logic for cache eviction is missing. However, since this is very static data, I refrained from implementing it here as well, considering the time specification. The strategy for this could be developed in several stages. The simple solution would be a time-controlled eviction. The better, but also more costly solution, would be a time-based check whether the data has been changed and to update the cache if this is the case.
I also generated an OpenAPI documentation, so I could generate all available requests and data objects for my frontend with the openapi-typescript-codegen npm package. The documentation can be accessed via https://swapi.lkaktus23.de/swagger-ui/index.html.