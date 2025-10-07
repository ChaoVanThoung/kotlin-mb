package com.example.mb_scanthub.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApp() {
    Scaffold(
        topBar = { TopBar() }
    ) { padding ->
        HomeScreen(Modifier.padding(padding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("Shop") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black
        ),
        actions = {
//            IconButton(onClick = { /* TODO: Handle search */ }) {
//                Icon(
//                    imageVector = Icons.Default.Search,
//                    contentDescription = "Search",
//                    tint = Color.Black
//                )
//            }
            IconButton(onClick = { /* TODO: Handle cart */ }) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Cart",
                    tint = Color.Black
                )
            }
        }
    )
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { SearchBar() }
        item { SectionTitle("Promotions") }
        item { PlaceholderBox(height = 150.dp, Modifier.fillMaxWidth()) }
        item { SectionTitle("Popular", showViewAll = true) }
        item { ProductRow() }
        item { SectionTitle("New Arrivals", showViewAll = true) }
        item { ProductRow() }
        item { SectionTitle("All", showViewAll = true) }
        item { ProductRow() }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        )
    )
}

@Composable
fun SectionTitle(title: String, showViewAll: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        if (showViewAll) {
            Text(
                "View all",
                color = Color.Blue,
                fontSize = 14.sp,
                modifier = Modifier.clickable { /* TODO: Handle view all */ }
            )
        }
    }
}

@Composable
fun ProductRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(4) { ProductItem() }
    }
}

@Composable
fun ProductItem() {
    Column(
        modifier = Modifier
            .width(150.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp)
            .clickable { /* TODO: Handle product click */ }
    ) {
        PlaceholderBox(height = 100.dp, Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Text("Brand name", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text("Model name", fontSize = 12.sp, color = Color.Gray)
        Text("Quantity", fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(4.dp))
        Text("$99.99", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
fun PlaceholderBox(height: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(height)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
    )
}