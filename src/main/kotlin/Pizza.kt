class Pizza(val order: String, val name: String?, val price: Int, val onion: Boolean, val sauce: Boolean) {
    constructor (builder: Builder) : this(  //вторичный конструктор, если туда нельзя передавать параметры, как передали builder, если его нет в теле класса
        builder.order,
        builder.name,
        builder.price,
        builder.onion,
        builder.sauce
    )


    companion object { // зачем мы пишем функцию в объекте?
    inline fun builder (order: String, block: Builder.() -> Unit) = Builder(order).apply(block)
        // код реализации инлайн функции ставится в место вызова, то есть лямбда будет тоже встроена в место вызова
        // каждый раз, когда вызывается лямбда, создается новый класс

    }

    class Builder(val order: String) {
        var name: String? = null
        var price: Int = 0
        val onion: Boolean = false
        val sauce: Boolean = false

        fun build() = Pizza(this)
    }



}
