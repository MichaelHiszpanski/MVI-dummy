package com.example.mvp_dummy.ui.components


import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvp_dummy.R
import com.example.mvp_dummy.analiticsHelper.AnalyticsHelper
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ConfirmationScreen( scrollState: ScrollState, navController: NavController) {

    var userEmail by remember { mutableStateOf("") }
    var userEmailError by remember { mutableStateOf<String?>(null) }
    val interactions = remember { MutableInteractionSource() }
    val isFocused by interactions.collectIsFocusedAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(50.dp))
        CoilImage(
            imageModel = R.drawable.icons_svg,
            // Crop, Fit, Inside, FillHeight, FillWidth, None
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(60.dp),
            error = ImageBitmap.imageResource(R.drawable.error),
            // shows a placeholder ImageBitmap when loading.
            placeHolder = ImageBitmap.imageResource(R.drawable.space))
        Spacer(modifier = Modifier.height(26.dp))
        Text(text = "Aby aktywować aplikację, proszę wpisać",fontWeight = FontWeight.SemiBold,style = TextStyle(fontSize = 18.sp))
        Text(text = "adres serwera i się połączyć",fontWeight = FontWeight.SemiBold,style = TextStyle(fontSize = 18.sp))
        Spacer(modifier = Modifier.height(26.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Adres serwera",fontWeight = FontWeight.SemiBold, style = TextStyle(fontSize = 16.sp))
            // InfoWithIcon(Icons.Default.DateRange, info =MockData.stringToDate(article.publishedAT?:"Nothing").getTimeAgo() )

        }
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextField()
        Spacer(modifier = Modifier.height(46.dp))
        Button(
            onClick = {



            },
            modifier = Modifier.fillMaxWidth()
                .height(50.dp),  // Set the height of the button
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFA500)  // Orange color
            )
        ) {
            androidx.compose.material3.Text("POLĄCZ", style = TextStyle(fontSize =20.sp , fontWeight =FontWeight.SemiBold ))
        }

    }
}

