package com.kodeco.upscaledrecycled

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kodeco.upscaledrecycled.ui.theme.UpscaledRecycledTheme
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            UpscaledRecycledTheme {
                val navController = rememberNavController()
                Scaffold { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "main",
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable("main") { HomeScreen(navController) }
                        composable("ourStory") { AboutUsScreen(navController) }
                        composable("contactUs") { ContactScreen(navController) }
                    }
                }
            }
        }
    }
}
@Composable
//Home Screen
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // outer padding
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Upscaled Recycled Fashion",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Subheadings
        Text(
            text = "A new approach to style!",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Unique, stylish clothing for an affordable price while helping to save the environment",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        //Image goes here

        // Tagline under the image
        Text(
            text = "Explore to find out what we're all about!",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )

        // Navigation buttons
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth())
        {
            Button(onClick = { navController.navigate("home") }) {
                Text("Main")
            }
            Button(onClick = { navController.navigate("ourStory") }) {
                Text("Our Story")
            }
            Button(onClick = { navController.navigate("contactUs") }) {
                Text("Contact Us")
            }
        }
    }
}

@Composable
//About Us
fun AboutUsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // outer padding
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title "Our Story" in Bold at the Top Center
        Text(
            text = "Our Story",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp) // bottom padding for space
        )

        // Story paragraph
        Text(
            text = """
                A core memory from my childhood was picking out my clothes for the school year with my mom and dad. 
                I always remember my parents buying me everything I needed: five shirts, five pairs of jeans/pants, and a good pair of shoes. 
                What I didn't know was that I was fortunate/privileged to have parents who cared about how I would be presented to the world. 
                The thought that others might not have been fortunate enough to have the same experience weighed heavily me. 
                So, it became my mission to produce affordable, stylish upcycled clothing for people who may be less fortunate than me.
            """,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            lineHeight = 24.sp, // Makes the paragraph more readable
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { navController.navigate("main") }) {
            Text("Back to Home")
        }
    }
}
@Composable
//Contact Us
fun ContactScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // outer padding
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title "Contact Us" in Bold at the Top Center
        Text(
            text = "Contact Us",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp) // bottom padding for space
        )

        // Subheading "We want to hear from you!"
        Text(
            text = "We want to hear from you!",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // Contact Email
        Text(
            text = "Contact: K. McFadden at upscaledandrecycled@gmail.com",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // Feedback Request
        Text(
            text = "Send your feedback and your donation!",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Our Sponsors Title
        Text(
            text = "Our Sponsors",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Levi's Button
        Button(
            onClick = {
                // Navigate to Levi's website
                val url = "https://www.levi.com"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                val context = navController.context
                ContextCompat.startActivity(context, intent, null)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Levi's")
        }
        Button(onClick = { navController.navigate("main") }) {
            Text("Back to Home")
        }

    }
}
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    UpscaledRecycledTheme {
        HomeScreen(navController = rememberNavController())
    }
}