package Models

class User {
    var name : String = ""
    var country :String = ""
    var phone:String = ""

    constructor(name: String, country: String, phone: String) {
        this.name = name
        this.country = country
        this.phone = phone
    }
}