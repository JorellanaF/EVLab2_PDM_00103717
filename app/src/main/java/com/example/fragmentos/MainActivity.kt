package com.example.fragmentos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}

/*
* private lateinit var mainFragment : PokemonsListFragment
    private lateinit var mainContentFragment: PokemonDetailsFragment

    private var pokemonList = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.imagen3.activity_main)
        pokemonList = savedInstanceState?.getParcelableArrayList(AppConstants.dataset_saveinstance_key) ?: ArrayList()

        initMainFragment()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(AppConstants.dataset_saveinstance_key, pokemonList)
        super.onSaveInstanceState(outState)
    }

    fun initMainFragment(){
        mainFragment = PokemonsListFragment.newInstance(pokemonList)

        val resource = if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            R.id.main_fragment
        else {
            mainContentFragment = PokemonDetailsFragment.newInstance(Pokemon())
            changeFragment(R.id.land_main_cont_fragment, mainContentFragment)

            R.id.land_main_fragment
        }

        changeFragment(resource, mainFragment)

        FetchPokemonTask().execute("")
    }

    fun addPokemonToList(pokemon: Pokemon) {
        pokemonList.add(pokemon)
        mainFragment.updatePokemonList(pokemonList)
        Log.d("Number", pokemonList.size.toString())
    }

    override fun searchPokemon(pokemonName: String) {
        QueryPokemonTask().execute(pokemonName)
    }

    override fun managePortraitItemClick(item: Pokemon) {

        Toast.makeText(this@MainActivity, "Click en Portrait", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, ViewerPokemon::class.java).putExtra("URL", item.url))

    }

    private fun changeFragment(id: Int, frag: Fragment){ supportFragmentManager.beginTransaction().replace(id, frag).commit() }

    override fun manageLandscapeItemClick(item: Pokemon) {
        Toast.makeText(this@MainActivity, "Click en Landscape", Toast.LENGTH_LONG).show()

        FetchPokemonDetailsTask().execute(item.url)
    }
    private inner class FetchPokemonTask : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg query: String): String {

            if (query.isNullOrEmpty()) return ""

            val ID = query[0]
            val pokeAPI = NetworkUtils().buildUrl("pokemon",ID)

            return try {
                NetworkUtils().getResponseFromHttpUrl(pokeAPI)
            } catch (e: IOException) {
                e.printStackTrace()
                ""
            }

        }

        override fun onPostExecute(pokemonInfo: String) {
            val pokemons = if (!pokemonInfo.isEmpty()) {
                val root = JSONObject(pokemonInfo)
                val results = root.getJSONArray("results")
                MutableList(20) { i ->
                    val result = JSONObject(results[i].toString())
                    Pokemon(i,
                        result.getString("name").capitalize(),
                        result.getString("url"),
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString())
                }
            } else {
                MutableList(20) {i->
                    Pokemon(i,
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString(),
                        R.string.default_n_a.toString())
                }
            }

            for (pokemon in pokemons) {
                addPokemonToList(pokemon)
            }
        }
}
* */