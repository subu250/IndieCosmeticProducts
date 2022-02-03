# Application Flow


### User Sign up

1. User chooses sign up on the welcome screen.
1. User fills out the sign up page and submit.
1. Request goes to sign up servlet and creates a object.
1.  User created in the database.

### User Sign In

1. User  sign in on the welcome screen.
1. User enters username and password on page and submits.
1. If user is authenticated, the server will handle allowing access to edit
   pages.  JDBCRealm used for authentication .
1. If authentication fails, show error message/page.

### View Product.

1. Page sends a request to view product servlet along with search criteria
1. Servlet uses the product dao to select products according to criteria
1. Dao returns list of products matching criteria to servlet.
1. Servlet sends list back to product  jsp.


### About

1. Static page - about products.


### Buy Product
1. available only to logged in users
1. User enters product  details
1. Details are sent to Buy Trail  servlet
1. Servlet creates product  object
1. Servlet sends object to dao
1. Dao adds product to the database
1. Servlet sends confirmation to product page that product has been purchased.



