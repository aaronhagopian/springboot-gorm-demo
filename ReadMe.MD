# Example springboot + gorm
Put together a simple project using springboot and gorm since the ones using GORM 6.0.x were not working for me.  

Should be able to run with

`$ gradle bootRun`

The project bootstraps a couple entries so 

`$ curl localhost:8080/persons/`

Should result in 3 entries.  You can also add entries using a PUT command and retrieve by id

`$ curl localhost:8080/persons/ -X PUT -d 'lastName=Fowler&firstName=Dexter`

`$ curl localhost:8080/persons/4/`



