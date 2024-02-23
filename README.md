Inspire me project

Overview
This project aims to create shop for art products based on spring boot backend application with PostgreSQL db, connected with React front-end application using Keycloak authorization server.
Main idea is to create a web application for buying, selling and reserving art products.

Implementation
Backend application will take care of all the logic and UI will take care for fast and responsive user experience.

Main views will be for:
- View all products for sale, filter them by properties for - NEW, ON SALE, BY Author/Vendor, BY Period
- login screen - from keycloak
- Adding item for sale by author/vendor
- List of all author/vendor items and their status
- Subscribe for newsletter from: Author/Vendor - send a newsletter with what's new content from specific author - if new products are present and for a week period of time

Authentication and authorization
Will be based on interaction with Keycloak server.
As a couple of roles are to be added: 
ADMIN - will see all the UI
NORMAL_USER - will be able to view the products catalog, but for reserving, buying, selling art - need to login or register
AUTHOR - will be able to add products for sale, view his products and their status, will be able also to buy and reserve another art products
VENDOR - will be able to add products for sale, view his products and their status, will be able also to buy and reserve another art products

Tasks to be implemented:
1. Add data model objects, add db script, connect BE to DB, add product method and expose it to API
2. Implement actions which can be done for product - CRUD operations, consider FileServer for images and extend model with art image and expose APIs - as add also quering with filtering API.
3. Initialize UI project - connect it to BE project
4. Implement main view in UI - show art products and filter them
5. Add UI view for Adding product and listing products with option to Edit/Delete/Buy product(optional wishlist)
6. Implement Authentication flow with keycloak
7. Implement authorization with keycloak

