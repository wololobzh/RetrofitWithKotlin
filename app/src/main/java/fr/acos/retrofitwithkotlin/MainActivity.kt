package fr.acos.retrofitwithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import fr.acos.retrofitwithkotlin.services.ChuckService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Activité pour tester l'accès au web service
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Création d'une implémentation de l'interface ChuckService
        val retrofit = Retrofit.Builder()
                .baseUrl(ChuckService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        //Récupération d'une instance de ChuckService
        val serviceChuck = retrofit.create(ChuckService::class.java)

        //Récupération d'un objet de type Call qui permettra de faire des requêtes sur le web service
        //Les requêtes ont cette forme : https://api.chucknorris.io/jokes/random
        val callServiceRandom = serviceChuck.randomFact()

        //Récupération d'un objet de type Call qui permettra de faire des requêtes sur le web service
        //Les requêtes ont cette forme : https://api.chucknorris.io/jokes/random?category=dev
        val callServiceCategory = serviceChuck.randomFactByCategory("random","dev")


        Thread{
            //Envoie de la requête
            val reponse =  callServiceCategory.execute()

            //Récupération du resultat de type FAct
            val fact = reponse.body()

            //Affichage
            runOnUiThread {
                tv_info.text = fact?.value
            }
        }.start()
    }
}
