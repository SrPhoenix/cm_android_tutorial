package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageUi(
                        stringResource(R.string.text_composable),
                        stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
                        stringResource(R.string.image_composable),
                        stringResource(R.string.creates_a_composa),
                        stringResource(R.string.row_composable),
                        stringResource(R.string.extra_asdas),
                        stringResource(R.string.column_composable),
                        stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence),
                    )
                }
            }
        }
    }
}

@Composable
private fun Quadrant(
    title: String,
    text: String,
    color:Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }
}

@Composable
fun PageUi(firstQuadrantTitle: String,
             firstQuadrantText: String,
             secondQuadrantTitle: String,
             secondQuadrantText: String,
             thirdQuadrantTitle: String,
             thirdQuadrantText: String,
             fourthQuadrantTitle: String,
             fourthQuadrantText: String,
             modifier: Modifier = Modifier) {
    Column (Modifier.fillMaxWidth()){
        Row (Modifier.weight(1f)){
            Quadrant(
                title = firstQuadrantTitle,
                text = firstQuadrantText,
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = secondQuadrantTitle,
                text = secondQuadrantText,
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row (Modifier.weight(1f)){
            Quadrant(
                title = thirdQuadrantTitle,
                text = thirdQuadrantText,
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title =  fourthQuadrantTitle,
                text = fourthQuadrantText,
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        PageUi(
            stringResource(R.string.text_composable),
            stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
            stringResource(R.string.image_composable),
            stringResource(R.string.creates_a_composa),
            stringResource(R.string.row_composable),
            stringResource(R.string.extra_asdas),
            stringResource(R.string.column_composable),
            stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence)
        )
    }
}