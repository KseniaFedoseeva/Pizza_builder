class Burger(
    var name: String?,
    var tomato: Boolean,
    var cheese: Boolean,
    var meat: Boolean,
    var price: Int
) {


    private constructor(builder: Builder) : this(
        builder.name,
        builder.cheese,
        builder.meat,
        builder.tomato,
        builder.price
    )


    class Builder {
        var name: String? = null
            private set
        var tomato: Boolean = false
            private set
        var cheese: Boolean = false
            private set
        var meat: Boolean = false
            private set
        var price: Int = 100
            private set

        fun tomato() = apply { this.tomato = tomato }
        fun name(name: String) = apply { this.name = name }

        fun build(): Burger {
            return Burger(this)
        }
    }
}