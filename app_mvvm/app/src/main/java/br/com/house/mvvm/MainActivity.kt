package br.com.house.mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.compose.ui.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.LiveData
import br.com.house.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels() // by -> por

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContent {
            MaterialTheme {
                myApp(viewModel.total)
            }
        }
    }

    @Composable
    fun myApp(somaData: LiveData<Int>) {
        val total = somaData.observeAsState(0)

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Aula 32") },
                    navigationIcon = {
                        IconButton(
                            onClick = { viewModel.refresh() }) {
                            Icons.Filled.Refresh
                        }
                        )
                    })
            },
            bodyContent = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(total.value.toString())
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    Toast.makeText(this, "Click", Toast.LENGTH_LONG).show()
                }) {
                    Icon(Icons.Filled.Add)
                }
            }
        )
    }
}