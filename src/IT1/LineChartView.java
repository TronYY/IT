package IT1;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.print.attribute.AttributeSet;
import javax.swing.text.View;

import com.sun.xml.internal.bind.CycleRecoverable.Context;
@SuppressLint({ "InlinedApi", "ClickableViewAccessibility" })
public class LineChartView extends View {
 private Paint paintAxis = new Paint(); //轴线与刻度画刷
 private Paint paintLine = new Paint(); //折线与标题画刷
 private Paint paintPoint = new Paint(); //数据点画刷
 private Paint paintClear = new Paint(); //清除画刷
 private String title = ""; //标题
 private int chartStartX; //图表X轴开始坐标
 private int chartStopX; //图表X轴结束坐标
 private int chartStartY; //图表Y轴开始坐标
 private int chartStopY; //图表Y轴结束坐标
 private int chartHeight; //图表高度
 private int chartWidth; //图表宽度
 private float max; //数据点最大值
 private float min; //数据点最小值
 private List dataSets = new ArrayList(); //数据集
 private int levelsX; //X轴刻度数
 private int levelsY; //Y轴刻度数
 private float spaceX; //X轴刻度间距
 private float spaceY; //Y轴刻度间距
 private int unit = 5; //刻度间的差
 private int length; //图表有效区域的X轴长度
 private int downX; //用户滑动前按下的X轴坐标
 private int offsetLeft = 50; //偏移量
 private boolean scrollabled = true; //是否可以滑动
 private boolean drew = false; //是否已绘
 private int maxDataSetsLength = -1; //最大数据集长度，-1为不限制
 public LineChartView(Context context) {
  super(context);
 }
 public LineChartView(Context context, AttributeSet attrs) {
  super(context, attrs);
 }
 @Override
 protected void onDraw(Canvas canvas) {
  super.onDraw(canvas);
  if (dataSets.isEmpty()) { //如果数据集为空则不进行绘制
   if (drew) {
    canvas.drawRect(0, 0, getWidth(), getHeight(), paintClear);
   } else {
    return;
   }
  }
  drew = true; //否则开始绘制，并标记 drew 为 true
  init();
  canvas.drawColor(Color.WHITE); //背景色
  //绘制X轴刻度、数据点、折线
  canvas.drawLine(chartStartX, chartStopY, chartStopX, chartStopY, paintAxis);
  paintAxis.setTextAlign(Align.CENTER);
  int j = (int) Math.ceil(0 - offsetLeft / spaceX) - 1;//此举是为多绘制可显示区域的前后各一个数据点作为缓冲
  for (int i = 0; i <= levelsx=""> 10 ? 10 : levelsX) + 1; i++, j++) {
   if (j < 0 || j >= dataSets.size()) { //防止数组下标越界
    continue;
   }
   DataSet currentPoint = dataSets.get(j);
   float x = getPointX(j);
   canvas.drawLine(x, chartStopY, x, chartStopY + 5, paintAxis);//绘制刻度
   canvas.drawText(currentPoint.name, x, chartStopY + 5 + 20, paintAxis);//绘制刻度文字
   //绘制折线
   float y = getPointY(currentPoint.value);
   if (j + 1 < dataSets.size()) {
    canvas.drawLine(x, y, getPointX(j + 1), getPointY(dataSets.get(j + 1).value), paintLine);
   }
   //绘制数据点
   canvas.drawCircle(x, y, 5, paintPoint);
  }
  //在绘制Y轴前覆盖越界内容
  canvas.drawRect(0, 0, chartStartX, getHeight(), paintClear);
  //绘制Y轴刻度
  canvas.drawLine(chartStartX, chartStartY, chartStartX, chartStopY, paintAxis);
  paintAxis.setTextAlign(Align.RIGHT);
  for (int i = 0; i < levelsY; i++) {
   float pointY = chartStopY - (i + 1) * spaceY; //点Y的位置
   canvas.drawLine(45, pointY, chartStartX, pointY, paintAxis); //绘制刻度
   canvas.drawText(String.valueOf((int) min + (i) * unit), 40, pointY + 8, paintAxis); //绘制刻度文字
  }
  //绘制标题
  if (title != null && !title.equals("")) {
   canvas.drawText(title, getWidth() / 2, 30, paintLine);
  }
 }
 /*
  * 根据数据点序号获得X坐标值
  */
 private float getPointX(int i) {
  return chartStartX + (i) * spaceX + offsetLeft;
 }
 /*
  * 根据数据值获得Y坐标值
  */
 private float getPointY(float value) {
  int exceedNum = (int) (Math.ceil(value - min) / unit) + 1; //计算将要逾越的刻度点数（不包含零刻线）
  float y = chartStopY - exceedNum * spaceY - (value - min) % unit / unit * spaceY;
  return y;
 }
 public void setScrollable(boolean scrollabled) {
  this.scrollabled = scrollabled;
 }
 /*
  * 设置标题
  */
 public void setTitle(String title) {
  this.title = title;
  invalidate();
 }
 /*
  * 清空图表
  */
 public void empty() {
  dataSets = new ArrayList();
  title = "";
  length = 0;
  invalidate();
 }
 /*
  * 初始化画刷与计算相关数据
  */
 private void init() {
  //计算图表 
  chartStartX = 50;
  chartStopX = getWidth();
  chartStartY = 50;
  chartStopY = getHeight() - 30;
  chartWidth = chartStopX - chartStartX;
  chartHeight = chartStopY - chartStartY;
  //轴线画刷
  paintAxis.setAntiAlias(true);
  paintAxis.setStrokeWidth(3);
  paintAxis.setColor(Color.parseColor("#858585"));
  paintAxis.setTextSize(18);
  //数据点画刷
  paintPoint.setAntiAlias(true);
  paintPoint.setStrokeWidth(3);
  paintPoint.setStyle(Paint.Style.FILL_AND_STROKE);
  paintPoint.setColor(Color.parseColor("#00aa3a"));
  //折线画刷
  paintLine.setAntiAlias(true);
  paintLine.setStrokeWidth(5);
  paintLine.setTextAlign(Align.CENTER);
  paintLine.setTextSize(35);
  paintLine.setColor(Color.parseColor("#00aa3a"));
  //擦除画刷
  paintClear.setColor(Color.WHITE);
  //获得最大值与最小值，以便于计算
  min = max = dataSets.get(0).value;
  for (int i = 1; i < dataSets.size(); i++) {
   DataSet set = dataSets.get(i);
   if (set.value < min) {     min = set.value;    }    if (set.value > max) {
    max = set.value;
   }
  }
  //计算X、Y轴相关数据以便于稍后绘制
  float minus = max - min;
  unit = (int) Math.ceil(minus / 10);
  unit = unit == 0 ? 1 : unit; //如果间距为0的话，则将其改为1，防止刻度无法递增
  levelsY = (int) (Math.ceil((max - min) / unit)); //Y轴需要绘制的刻度数
  if (levelsY == 0) { //如果只有0个刻度时，即一直为持平趋势时增加一个刻度，使唯一一个刻度能绘制至中间
   levelsY++;
  }
  spaceY = chartHeight / (levelsY + 1); //Y轴刻度间的距离，+1是为了给前后留出空间
  levelsX = dataSets.size(); //X轴需要绘制的刻度数
  spaceX = chartWidth / (levelsX > 10 ? 10 : levelsX + 1); //X轴刻度间的距离，+1是为了给前后留出空间
  length = (int) (dataSets.size() * spaceX);
 }
 /*
  * 添加数据集
  */
 public void addDataSet(DataSet dataSet) {
  if (maxDataSetsLength != -1 && dataSets.size() > maxDataSetsLength) {
   dataSets.remove(0);
  }
  dataSets.add(dataSet);
  scrollToEnd();
 }
 public void setMaxDataSetsLength(int maxDataSetsLength) {
  this.maxDataSetsLength = maxDataSetsLength;
 }
 /*
  * 滚动到首部
  */
 public void scrollToStart() {
  if (!drew) {
   invalidate();
  }
  offsetLeft = 50;
  invalidate();
 }
 /*
  * 滚动到尾部
  */
 public void scrollToEnd() {
  if (!drew) {
   invalidate();
  }
  offsetLeft = chartWidth >= length ? 50 : (0 - (length - chartWidth) - 50);
  invalidate();
 }
 /*
  * 是否已滚动到尾部
  */
 public boolean isScrolledToStart() {
  return offsetLeft >= 50;
 }
 /*
  * 是否已滚动到首部
  */
 public boolean isScrolledToEnd() {
  return chartWidth >= length ? (offsetLeft <= 50) : (offsetLeft < 0 - (length - chartWidth));
 }
 /*
  * 设置数据集
  */
 public void setDataSets(List dataSets) {
  length = 0;
  this.dataSets = dataSets;
  invalidate();
  scrollToEnd();
 }
 /*
  * 触摸时间，检测用户是否滑动
  */
 @SuppressLint("ClickableViewAccessibility")
 @Override
 public boolean onTouchEvent(MotionEvent event) {
  switch (event.getAction()) {
  case MotionEvent.ACTION_DOWN:
   downX = (int) event.getRawX();
   break;
  case MotionEvent.ACTION_MOVE:
   if (!scrollabled)
    return true;
   //distanceX<0为手指向左滑动，distancex>0为手指向右滑动
   int distanceX = (int) event.getRawX() - downX;//移动的距离
   offsetLeft += distanceX;
   downX = (int) event.getRawX();
   if (isScrolledToStart()) {
    scrollToStart();
   } else if (isScrolledToEnd()) {
    scrollToEnd();
   } else {
    invalidate();
   }
   break;
  case MotionEvent.ACTION_UP:
   break;
  }
  return true;
 }
 public static class DataSet {
  public String name;
  public float value;
  public DataSet(String name, float value) {
   this.name = name;
   this.value = value;
  }
 }
}
我们可以在布局中这样使用：

<hk.jerry.linechart.LineChartView
 android:id="@+id/lc_test"
 android:layout_width="match_parent"
 android:layout_height="match_parent"/>
然后添加数据：
LineChartView lcHistory = (LineChartView) findViewById(R.id.lc_test);
//测试数据 lcHistory.setTitle("测试图表");
Random random = new Random(10);
for (i = 0; i < 50; i++) {
    lcHistory.addDataSet(new DataSet((50 - i) + "分钟前", random.nextInt(40)));
}