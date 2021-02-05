package com.bkjcb.gasuserrecord.util

import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import com.bkjcb.gasuserrecord.model.GasStatisticData
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter
import com.github.mikephil.charting.formatter.DefaultValueFormatter
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.*

/**
 * Created by DengShuai on 2021/2/3.
 * Description :
 */
object ChartUtil {

    fun initPieChart(chart: PieChart, list: List<GasStatisticData>?) {
        if (list.isNullOrEmpty()){
            return
        }
        chart.setBackgroundColor(Color.WHITE)

        chart.setUsePercentValues(true)
        chart.description.isEnabled = false
        chart.isDrawHoleEnabled = true
        chart.setHoleColor(Color.WHITE)

        chart.setTransparentCircleColor(Color.WHITE)
        chart.setTransparentCircleAlpha(110)

        chart.holeRadius = 58f
        chart.transparentCircleRadius = 61f

        chart.setDrawCenterText(true)

        chart.isRotationEnabled = true
        chart.isHighlightPerTapEnabled = true

        /* chart.setMaxAngle(180f); // HALF CHART
            chart.setRotationAngle(180f);*/

        /* chart.setMaxAngle(180f); // HALF CHART
            chart.setRotationAngle(180f);*/
        chart.animateY(1000, Easing.EaseInOutQuad)
        val l: Legend = chart.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
        l.xEntrySpace = 7f
        l.yEntrySpace = 0f
        l.yOffset = 0f
        l.isWordWrapEnabled = true
        // entry label styling
        // entry label styling
        chart.setEntryLabelColor(Color.WHITE)
        chart.setEntryLabelTextSize(12f)
        chart.setUsePercentValues(false)
        val values = ArrayList<PieEntry>()
        var count: Float
        var allCount = 0f
        for (data: GasStatisticData in list) {
            if (!TextUtils.isEmpty(data.gs)) {
//                    count = TextUtils.isEmpty(data.getGs()) ? 0 : Float.parseFloat(data.getGs());
                count = data.gs!!.toFloat()
                if (count > 0) {
                    values.add(PieEntry(count, data.name))
                    allCount += count
                }
            }
        }

        val dataSet = PieDataSet(values, "")
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f

        dataSet.colors = getColors()
        //dataSet.setSelectionShift(0f);

        //dataSet.setSelectionShift(0f);
        val data = PieData(dataSet)

        /*  dataSet.setValueLinePart1OffsetPercentage(80.f);
            dataSet.setValueLinePart1Length(0.2f);
            dataSet.setValueLinePart2Length(0.4f);

            //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
            dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);*/


        /*  dataSet.setValueLinePart1OffsetPercentage(80.f);
            dataSet.setValueLinePart1Length(0.2f);
            dataSet.setValueLinePart2Length(0.4f);

            //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
            dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);*/
        data.setValueFormatter(
            DefaultValueFormatter(0)
        )
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        chart.data = data
        chart.centerText = generateCenterSpannableText(allCount.toInt())
        chart.setCenterTextOffset(0f, -20f)
        chart.invalidate()
    }

    fun initBarChart(chart: BarChart, list: List<GasStatisticData>?){
        if (list.isNullOrEmpty()){
            return
        }
        chart.setDrawBarShadow(false)
        chart.setDrawValueAboveBar(true)

        chart.description.isEnabled = false
        // scaling can now only be done on x- and y-axis separately
        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false)

        chart.setDrawGridBackground(false)
        // chart.setDrawYLabels(false);

        // chart.setDrawYLabels(false);
        val xAxis: XAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 1f // only intervals of 1 day
        xAxis.labelCount = 7


        val leftAxis: YAxis = chart.axisLeft
        leftAxis.setLabelCount(8, false)
        leftAxis.valueFormatter = DefaultAxisValueFormatter(0)
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        leftAxis.spaceTop = 15f
        leftAxis.axisMinimum = 0f // this replaces setStartAtZero(true)


        val rightAxis: YAxis = chart.axisRight
        rightAxis.isEnabled = false

        val l: Legend = chart.legend
        l.isEnabled = false
        val values = ArrayList<BarEntry>()
        val legendNames:ArrayList<String> = ArrayList()
        var number = 0F
        for (i in list.indices) {
            val data = list[i]
            if (!TextUtils.isEmpty(data.gs)) {
                val count: Float = data.gs!!.toFloat()
                if (count > 0) {
                    legendNames.add (data.name?:"")
                    values.add(BarEntry(number++, count))
                }
            }
        }
        xAxis.valueFormatter = MyBarChartLegendFormatter(legendNames)
        val set = BarDataSet(values, "")
        set.colors = getColors()
        set.setDrawValues(true)

        val dataSets = ArrayList<IBarDataSet>()
        dataSets.add(set)

        val barData = BarData(dataSets)
        chart.data = barData
        chart.setFitBars(true)


        chart.invalidate()
    }

    private fun getColors(): ArrayList<Int> {
        val colors = ArrayList<Int>()
        colors.addAll(ColorTemplate.COLORFUL_COLORS.asList())
        colors.addAll(ColorTemplate.VORDIPLOM_COLORS.asList())
        colors.addAll(ColorTemplate.JOYFUL_COLORS.asList())
        colors.addAll(ColorTemplate.LIBERTY_COLORS.asList())
        return colors
    }


    private fun generateCenterSpannableText(count: Int): SpannableString {
        val s = SpannableString("总户数\n$count")
        s.setSpan(RelativeSizeSpan(1.0f), 0, 3, 0)
        s.setSpan(StyleSpan(Typeface.NORMAL), 3, s.length, 0)
        s.setSpan(RelativeSizeSpan(2.4f), 3, s.length, 0)
        s.setSpan(StyleSpan(Typeface.ITALIC), 3, s.length, 0)
        s.setSpan(ForegroundColorSpan(ColorTemplate.getHoloBlue()), 3, s.length, 0)
        return s
    }

    class MyBarChartLegendFormatter(private val names: List<String>) :
        ValueFormatter() {

        override fun getFormattedValue(value: Float): String {
            return names[value.toInt()]
        }
    }

}