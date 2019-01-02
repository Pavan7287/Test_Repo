import org.springframework.cloud.contract.spec.Contract

Contract.make{

    description("""
    Validating A CWP MO For New Customer
    """)
    
    request{
    
    method 'POST'
    url    '/ValidateMO'
    body(file("cwp_mo.json"))
    bodyMatchers {
        jsonPath('$.id',byRegex("[0-9]{2}"))
        jsonPath('$.name',byRegex('[A-Za-z]+'))
        jsonPath('$.age',byRegex('[2-9][0-9]'))
        jsonPath('$.salary',byRegex('[1-9][0-9]{5}'))
        jsonPath('$.designation',byRegex('[A-Za-z]+'))
        jsonPath("\$.['address'][*].['zipCode']",byRegex('[0-9]{5}'))



    }
    headers {
			contentType(applicationJson())
	}
   }
   response{
     status 200
     body("""
     {
     "status":"OK"
     }
     """)
     headers{
     contentType(applicationJson())
     }
   }
 
}
