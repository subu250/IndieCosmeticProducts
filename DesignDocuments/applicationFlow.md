# Application Flow


### User Sign up

1. User chooses sign up on the welcome screen.
1. User fills out the sign up page and submit.
1. Request goes to sign up servlet and creates a object.
1.  User created in the database.

### User Sign In

1. User  sign in on the welcome screen.
2. User enters username and password on page and submits.
3. If user is authenticated, the server will handle allowing access to edit
   pages. 
4. If authentication fails, show error message/page.

### View Product.

1. Page sends a request to view product servlet along with search criteria
2. Servlet uses the product dao to select products according to criteria
3. Dao returns list of products matching criteria to servlet.
4. Servlet sends list back to product  jsp.


### Add Product
1. available only to logged in users
2. User enters product  details
3. Servlet creates product  object
4. Servlet sends object to dao
5. Dao adds product to the database
6. Servlet sends confirmation to product page that product has been purchased.

### Delete Products
1.User enters product  details
2. Servlet creates product  object
3.Servlet sends object to dao
4.Dao deleted product from  the database
5.Servlet sends confirmation to product page that product has been removed.

### Search for Catalog

1.Users logged into the app
2.Search product catalog.








