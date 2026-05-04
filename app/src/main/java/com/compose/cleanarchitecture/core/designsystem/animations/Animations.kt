package com.compose.cleanarchitecture.core.designsystem.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object AppAnimations {
    val fadeIn: EnterTransition = fadeIn(animationSpec = androidx.compose.animation.core.tween(300))
    val fadeOut: ExitTransition = fadeOut(animationSpec = androidx.compose.animation.core.tween(300))

    val slideUp: EnterTransition = slideInVertically(initialOffsetY = { it }) + fadeIn()
    val slideDown: ExitTransition = slideOutVertically(targetOffsetY = { it }) + fadeOut()

    val expandCollapse: EnterTransition = expandVertically() + fadeIn()
    val shrinkCollapse: ExitTransition = shrinkVertically() + fadeOut()
}

@Composable
fun FadeInVisibility(
    visible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = AppAnimations.fadeIn,
        exit = AppAnimations.fadeOut,
        modifier = modifier
    ) {
        content()
    }
}

@Composable
fun SlideUpVisibility(
    visible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = AppAnimations.slideUp,
        exit = AppAnimations.slideDown,
        modifier = modifier
    ) {
        content()
    }
}
