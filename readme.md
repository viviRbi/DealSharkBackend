# Essential note between team member

### register url
http://localhost:8080/Project-2/register
### login url
http://localhost:8080/Project-2/authenticateUser
### Update savedGame (post request contains saved game ids string and user id for now)
http://localhost:8080/Project-2/updateSavedGame
### Get saved game by user id. 123 is user id (not needed for now)
http://localhost:8080/Project-2/getSavedGame/123

![DealShark Plan](DealShark_plan_png.png)

Screenshots:
Home Screen when haven't log in
![DealShark img1](screenShot/home.jpg)
Sort game list by MetaCritic. When clicked on any of the table header, we are able to sort by ascending or descending on title, sale price, release day, metacritic, deal rating inside GameList Component. We can go to its game detail page by click on a row
![DealShark img2](screenShot/gamelist-sort.jpg)
Filter game list by title Sonic with lowest price 20 and highest price 50
![DealShark img1](screenShot/gamelist-search.jpg)
Save Game page. The ids of all the saved game were retrieved when user login. Other data like title, metacritic, release date were retrieved by forkJoin multiple http get request (get by id) and stored inside an array then they were turned to Json and added into session
![DealShark img1](screenShot/savedgame.jpg)
Game detail when haven't login
![DealShark img1](screenShot/gamedetail.jpg)
Game detail when login
![DealShark img1](screenShot/gamedetail-loggin.jpg)
Login page when inputs have been touched and the requirement haven't been met
![DealShark img1](screenShot/login-false.jpg)
User profile update when just go to profile page. The submit button is disable for not meeting the requirement
![DealShark img1](screenShot/update.jpg)
Register page when user just login and hovered around the disabled register button
![DealShark img1](screenShot/register.jpg)