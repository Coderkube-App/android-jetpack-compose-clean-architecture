package com.compose.cleanarchitecture.core.designsystem.tokens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.standardCardStyle(): Modifier = this
    .fillMaxWidth()
    .shadow(elevation = 4.dp, shape = MaterialTheme.shapes.large)
    .background(MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.large)
    .clip(MaterialTheme.shapes.large)
    .padding(LocalSpacing.current.medium)

@Composable
fun Modifier.appScreenPadding(): Modifier = this
    .padding(LocalSpacing.current.medium)

@Composable
fun Modifier.roundedBackground(color: Color = MaterialTheme.colorScheme.surfaceVariant): Modifier = this
    .background(color, shape = RoundedCornerShape(12.dp))
    .clip(RoundedCornerShape(12.dp))
    .padding(12.dp)
