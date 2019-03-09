@Grab("groovy-json")
import groovy.json.JsonSlurper 

@RestController
class AccountApi {
    
    @GetMapping(value="/banks/{BANK_ID}/accounts")
    def getAccountByBankId(@PathVariable("BANK_ID") bankId) {  
       parseJson(
        """{
            "accounts":[
                {
                    "id":"8ca8a7e4-6d02-48e3-a029-0b2bf89de9f0",
                    "label":"NoneLabel",
                    "bank_id":"${bankId}",
                    "number":"this is account number"
                }
                ]    
            }
        """
        )
    }

    def parseJson(jsonStr) {
        new JsonSlurper().parseText(jsonStr)
    }
}
