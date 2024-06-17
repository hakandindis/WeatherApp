package com.hakandindis.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle

class WeatherAppWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val widgetId = GlanceAppWidgetManager(context).getAppWidgetId(id)
        provideContent {
            GlanceTheme {
                WeatherAppWidgetContent()
            }
        }
    }
}

@Composable
fun WeatherAppWidgetContent() {
    Scaffold {
        Box(
            modifier = GlanceModifier.fillMaxSize().padding(16.dp),
        ) {
            Row(
                modifier = GlanceModifier.fillMaxWidth(),
            ) {
                Image(
                    modifier = GlanceModifier.width(24.dp).height(24.dp),
                    provider = ImageProvider(R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
                Box(
                    modifier = GlanceModifier.padding(start = 8.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Column(
                        modifier = GlanceModifier, horizontalAlignment = Alignment.Horizontal.End,
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(text = "Tokyo", style = TextStyle(fontWeight = FontWeight.Medium))
                        Text(
                            text = "Mostly Cloudy",
                            style = TextStyle(fontWeight = FontWeight.Medium)
                        )
                    }
                }

            }

        }
    }

}