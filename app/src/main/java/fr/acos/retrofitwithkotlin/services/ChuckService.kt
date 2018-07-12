package fr.acos.retrofitwithkotlin.services

import fr.acos.retrofitwithkotlin.bo.Fact
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interface permettant de créer les fonctions d'accès au webservice
 */
interface ChuckService {

    companion object {
        val url ="https://api.chucknorris.io/jokes/"
    }

    /**
     * Permet d'envoyer une requête qui retournera un objet de type Fact
     * Requête GET de la forme
     * https://api.chucknorris.io/jokes/random
     */
    @GET("random")
    fun randomFact(): Call<Fact>

    /**
     * Permet d'envoyer une requête qui retournera un objet de type Fact
     * Requête GET de la forme
     * https://api.chucknorris.io/jokes/random/{complement}?category={category}
     * {complement} et {category} sont paramétrable.
     */
    @GET("{complement}")
    fun randomFactByCategory(@Path("complement")complement:String, @Query("category")category:String): Call<Fact>
}