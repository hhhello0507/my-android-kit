package com.hhhello0507.mydesignsystem.component.button

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.layout
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.ui.util.fastMap
import com.hhhello0507.mydesignsystem.foundation.MyTheme
import com.hhhello0507.mydesignsystem.internal.MyPreviews
import com.hhhello0507.mydesignsystem.internal.bounceClick
import kotlinx.coroutines.launch

interface SegmentedButton {
    val text: String
}

@Composable
fun MySegmentedButton(
    modifier: Modifier = Modifier,
    selected: Int,
    onChange: (Int) -> Unit,
    buttons: List<SegmentedButton>,
    containerColor: Color = MyTheme.colorScheme.fillNeutral,
    containerShape: Shape = RoundedCornerShape(12.dp),
    indicatorColor: Color = MyTheme.colorScheme.fillAssistive,
    indicatorShape: Shape = RoundedCornerShape(10.dp),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
) {
    BoxWithConstraints {
        val itemWidth = maxWidth / buttons.size

        MySegmentedButton(
            modifier = modifier,
            selectedIndex = selected,
            containerColor = containerColor,
            containerShape = containerShape,
            indicatorColor = indicatorColor,
            indicatorShape = indicatorShape,
            tonalElevation = tonalElevation,
            shadowElevation = shadowElevation,
            border = border
        ) {
            buttons.fastForEachIndexed { index, button ->
                MySegmentedButtonItem(
                    modifier = Modifier.width(itemWidth),
                    text = button.text,
                    selected = index == selected,
                    onClick = {
                        onChange(index)
                    }
                )
            }

        }
    }
}

@Composable
fun MySegmentedButton(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    containerColor: Color = MyTheme.colorScheme.fillNeutral,
    containerShape: Shape = RoundedCornerShape(12.dp),
    indicatorColor: Color = MyTheme.colorScheme.fillAssistive,
    indicatorShape: Shape = RoundedCornerShape(10.dp),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    buttonItems: @Composable () -> Unit,
) {
    var buttonWidth by remember { mutableStateOf(0.dp) }
    val buttonWidthAnim by animateDpAsState(targetValue = buttonWidth, label = "")
    val scope = remember {
        object : SegmentedIndicatorScope, SegmentedButtonPositionsHolder {
            val segmentedButtonPositions = mutableStateOf<(List<SegmentedButtonPosition>)>(listOf())

            override fun Modifier.segmentedIndicatorLayout(measure: MeasureScope.(Measurable, Constraints, List<SegmentedButtonPosition>) -> MeasureResult) =
                this.layout { measurable: Measurable, constraints: Constraints ->
                    this.measure(
                        measurable,
                        constraints,
                        segmentedButtonPositions.value,
                    )
                }


            override fun Modifier.segmentedIndicatorOffset(
                selectedNavigationIndex: Int,
                matchContentSize: Boolean
            ) = this then SegmentedIndicatorModifier(
                segmentedButtonPositions,
                selectedNavigationIndex,
                matchContentSize,
            )

            override fun setSegmentedButtonPositions(positions: List<SegmentedButtonPosition>) {
                segmentedButtonPositions.value = positions
            }
        }
    }

    Surface(
        modifier = Modifier
            .selectableGroup(),
        color = containerColor,
        shape = containerShape,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
    ) {
        Layout(
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp),
            contents = listOf(
                buttonItems,
                {
                    scope.run {
                        Surface(
                            modifier = Modifier
                                .height(48.dp)
                                .width(buttonWidthAnim)
                                .padding(
                                    vertical = 4.dp,
                                    horizontal = 4.dp,
                                )
                                .segmentedIndicatorOffset(
                                    selectedNavigationIndex = selectedIndex,
                                    matchContentSize = true,
                                ),
                            color = Color.Transparent,
                            shape = indicatorShape,
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        indicatorColor,
                                        indicatorShape,
                                    ),
                            )
                        }
                    }
                },
            ),
        ) { (navItemMeasurables, indicatorMeasurables), constraints ->
            require(navItemMeasurables.size > 1) { "Segments size must be higher than 1" }

            val navigationBarWidth = constraints.maxWidth
            val navigationBarHeight = constraints.maxHeight
            val buttonItemCount = navItemMeasurables.size
            var navItemWidth = 100
            if (buttonItemCount > 0) {
                navItemWidth = (navigationBarWidth / buttonItemCount)
                buttonWidth = navItemWidth.toDp()
            }

            scope.setSegmentedButtonPositions(
                List(buttonItemCount) { index ->

                    SegmentedButtonPosition(navItemWidth.toDp() * index, navItemWidth.toDp())
                },
            )

            val navItemPlaceableList = navItemMeasurables.fastMap {
                it.measure(Constraints())
            }

            val indicatorPlaceableList = indicatorMeasurables.fastMap {
                it.measure(Constraints())
            }

            layout(navigationBarWidth, navigationBarHeight) {
                indicatorPlaceableList.fastForEach {
                    it.placeRelative(
                        (navItemWidth - it.width) / 2,
                        (navigationBarHeight - it.height) / 2
                    )
                }

                navItemPlaceableList.fastForEachIndexed { index, placeable ->
                    placeable.placeRelative(
                        (navItemWidth * index) + ((navItemWidth - placeable.width) / 2),
                        (navigationBarHeight - placeable.height) / 2
                    )
                }
            }
        }
    }
}

internal data class SegmentedIndicatorModifier(
    val navItemPositionsState: State<List<SegmentedButtonPosition>>,
    val selectedNavItemIndex: Int,
    val followContentSize: Boolean,
) : ModifierNodeElement<SegmentedIndicatorOffsetNode>() {
    override fun create(): SegmentedIndicatorOffsetNode {
        return SegmentedIndicatorOffsetNode(
            navItemPositionsState = navItemPositionsState,
            selectedNavItemIndex = selectedNavItemIndex,
            followContentSize = followContentSize,
        )
    }

    override fun update(node: SegmentedIndicatorOffsetNode) {
        node.navItemPositionsState = navItemPositionsState
        node.selectedNavItemIndex = selectedNavItemIndex
        node.followContentSize = followContentSize
    }

    override fun InspectorInfo.inspectableProperties() {
        // Show nothing in the inspector.
    }
}

internal class SegmentedIndicatorOffsetNode(
    var navItemPositionsState: State<List<SegmentedButtonPosition>>,
    var selectedNavItemIndex: Int,
    var followContentSize: Boolean,
) : Modifier.Node(), LayoutModifierNode {

    private var offsetAnimatable: Animatable<Dp, AnimationVector1D>? = null
    private var widthAnimatable: Animatable<Dp, AnimationVector1D>? = null
    private var initialOffset: Dp? = null
    private var initialWidth: Dp? = null

    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        if (navItemPositionsState.value.isEmpty()) {
            return layout(0, 0) { }
        }

        val currentTabWidth = constraints.maxWidth.toDp()
        if (followContentSize) {
            initialWidth = currentTabWidth
        }

        val indicatorOffset = navItemPositionsState.value[selectedNavItemIndex].left

        if (initialOffset != null) {
            val offsetAnim =
                offsetAnimatable ?: Animatable(initialOffset!!, Dp.VectorConverter).also {
                    offsetAnimatable = it
                }

            if (indicatorOffset != offsetAnim.targetValue) {
                coroutineScope.launch { offsetAnim.animateTo(indicatorOffset) }
            }
        } else {
            initialOffset = indicatorOffset
        }

        val offset = offsetAnimatable?.value ?: indicatorOffset

        val placeable = measurable.measure(
            if (followContentSize) {
                val width = widthAnimatable?.value ?: currentTabWidth
                constraints.copy(minWidth = width.roundToPx(), maxWidth = width.roundToPx())
            } else {
                constraints
            },
        )

        return layout(placeable.width, constraints.maxHeight) {
            placeable.place(offset.roundToPx(), constraints.maxHeight - placeable.height)
        }
    }
}

interface SegmentedIndicatorScope {
    fun Modifier.segmentedIndicatorLayout(
        measure: MeasureScope.(
            Measurable,
            Constraints,
            List<SegmentedButtonPosition>,
        ) -> MeasureResult,
    ): Modifier

    fun Modifier.segmentedIndicatorOffset(
        selectedNavigationIndex: Int,
        matchContentSize: Boolean = false
    ): Modifier
}

internal interface SegmentedButtonPositionsHolder {
    fun setSegmentedButtonPositions(positions: List<SegmentedButtonPosition>)
}

data class SegmentedButtonPosition(
    val left: Dp,
    val width: Dp,
    val right: Dp = left + width,
)

@Composable
fun MySegmentedButtonItem(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Text(
        modifier = modifier
            .bounceClick(
                onClick = onClick,
            )
            .alpha(if (selected) 1f else 0.5f),
        textAlign = TextAlign.Center,
        text = text,
        color = MyTheme.colorScheme.labelNormal,
        style = MyTheme.typography.headlineM
    )
}


@Composable
@MyPreviews
private fun MySegmentedButtonPreview() {
    MyTheme {
        Surface(
            color = MyTheme.colorScheme.backgroundNormal,
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .padding(20.dp)
                    .height(48.dp)
            ) {
                val dummyItems: List<String> = listOf("선생님", "학생")
                val itemWidth = maxWidth / dummyItems.size
                var selectedTabIndex by remember { mutableIntStateOf(0) }
                MySegmentedButton(
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth(),
                    containerShape = RoundedCornerShape(12.dp),
                    indicatorShape = RoundedCornerShape(8.dp),
                    selectedIndex = selectedTabIndex,
                ) {
                    dummyItems.fastForEachIndexed { index, text ->
                        MySegmentedButtonItem(
                            modifier = Modifier
                                .width(itemWidth),
                            text = text,
                            selected = index == selectedTabIndex,
                        ) {
                            selectedTabIndex = index
                        }
                    }
                }
            }
        }
    }
}