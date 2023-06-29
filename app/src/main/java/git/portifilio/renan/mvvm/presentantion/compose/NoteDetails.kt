package git.portifilio.renan.mvvm.presentantion.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import git.portifilio.renan.mvvm.R
import git.portifilio.renan.mvvm.presentantion.compose.ui.theme.MVVMTheme

class NoteDetails : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)

    Column {
        Text(
            text = name,
            fontSize = 36.sp,
        )
        Text(
            text = name,
            fontSize = 24.sp,
        )
//        Image(painter = image, contentDescription ="AS" )

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMTheme {
        Greeting("Android")
    }
}