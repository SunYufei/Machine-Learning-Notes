const getSidebar = require('./sidebar')

getSidebar(
   '/java/',
   '/db/',
   '/spring/',
   '/git.md',
   '/os/',
   '/net/',
   '/algorithm/',
   '/design-pattern/',
   '/middle-ware/',
   '/ORM/',
   '/micro-service/',
   '/container/',
   '/architecture/',
   '/front-end/'
).forEach((item) => console.log(item))
