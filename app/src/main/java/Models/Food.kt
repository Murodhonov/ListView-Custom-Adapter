package Models

class Food {
    var name : String = ""
    var ingradients :String = ""
    var preparationOrder:String = ""

    constructor(name: String, ingradients: String, preparationOrder: String) {
        this.name = name
        this.ingradients = ingradients
        this.preparationOrder = preparationOrder
    }
}