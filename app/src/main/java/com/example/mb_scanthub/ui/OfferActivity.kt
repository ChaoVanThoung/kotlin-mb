package com.example.mb_scanthub.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mb_scanthub.ui.theme.PrimaryColor
import com.example.mb_scanthub.ui.theme.SecondaryColor

class OfferActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OfferScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen() {
    val backgroundColor = PrimaryColor
    val cardColor = PrimaryColor
    val context = LocalContext.current


    val products = listOf(
        Product("Giorgio Armani Stronger With You", "100 ml", "$99.99"),
        Product("Valentino Born in Roma Intense", "100 ml", "$99.99"),
        Product("Dior Sauvage", "100 ml", "$99.99"),
        Product("Chanel Bleu de Chanel", "100 ml", "$99.99"),
        Product("Versace Eros", "100 ml", "$99.99"),
        Product("Yves Saint Laurent Libre", "100 ml", "$99.99")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("All Offer", color = SecondaryColor) },
                navigationIcon = {
                    // ← Back button works now
                    IconButton(onClick = {
                        (context as? ComponentActivity)?.finish()
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notification", tint = Color.White)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = backgroundColor)
            )
        },
        containerColor = backgroundColor
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(backgroundColor)
        ) {
            // Sort and Filter Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(cardColor)
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("Sort", color = Color.White, fontSize = 16.sp)
                Text("Filter", color = Color.White, fontSize = 16.sp)
            }

            // Product Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(8.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(products) { product ->
                    ProductCard(product = product, cardColor = cardColor)
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, cardColor: Color) {
    Card(
        colors = CardDefaults.cardColors(containerColor = cardColor),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Blank space for image placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color(0xFF5A3E2D), shape = RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.name,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = product.size,
                color = Color.LightGray,
                fontSize = 12.sp
            )
            Text(
                text = product.price,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 4.dp)
            )
        }
    }
}

data class Product(
    val name: String,
    val size: String,
    val price: String
)
