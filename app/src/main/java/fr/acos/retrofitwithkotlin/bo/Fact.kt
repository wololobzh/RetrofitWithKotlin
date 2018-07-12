package fr.acos.retrofitwithkotlin.bo

/**
 * Classe objet permettant de receptionner les valeurs de la réponse JSON du webservice
 * Les propriété doivent avoir les même noms que les propriétés de la réponse JSON.
 */
data class Fact
(
    val category:List<String>,
    val icon_url:String,
    val id:String,
    val url:String,
    val value:String
)
