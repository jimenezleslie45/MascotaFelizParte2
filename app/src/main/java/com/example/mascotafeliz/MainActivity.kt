package com.example.mascotafeliz

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mascotafeliz.ui.theme.MascotaFelizTheme
import com.google.mlkit.vision.text.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MascotaFelizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("Android")
                    Elementos()
                }
            }
        }
    }
}

@Composable
fun Elementos() {
    val mContext = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(shape= MaterialTheme.shapes.small).background(MaterialTheme.colorScheme.secondary)
                .border(4.dp, MaterialTheme.colorScheme.primary)

        ){
            Image(
                painter = painterResource(id = R.drawable.perritoliz),
                contentDescription = "Mascota perritoliz",
                modifier = Modifier
                    .padding((20.dp))
            )
        }

        Text(
            "Mascota Feliz",
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = 36.sp
        )
        Text("Bienvenido, usuario" ,
            color = MaterialTheme.colorScheme.primary
        )
        Row() {
            OutlinedButton(onClick = {/*TODO*/ }) {
                Text("Tu mascota",
                    color = MaterialTheme.colorScheme.onSecondary,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedButton(
                onClick = {
                    mContext.startActivity(Intent(mContext, ListActivity::class.java))
                }
            ) {
                Text("Contenidos",
                    color = MaterialTheme.colorScheme.onSecondary,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ElementosPreview(){
    MascotaFelizTheme {
        Elementos()
    }
}