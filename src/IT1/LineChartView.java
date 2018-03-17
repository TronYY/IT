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
 private Paint paintAxis = new Paint(); //������̶Ȼ�ˢ
 private Paint paintLine = new Paint(); //��������⻭ˢ
 private Paint paintPoint = new Paint(); //���ݵ㻭ˢ
 private Paint paintClear = new Paint(); //�����ˢ
 private String title = ""; //����
 private int chartStartX; //ͼ��X�Ὺʼ����
 private int chartStopX; //ͼ��X���������
 private int chartStartY; //ͼ��Y�Ὺʼ����
 private int chartStopY; //ͼ��Y���������
 private int chartHeight; //ͼ��߶�
 private int chartWidth; //ͼ����
 private float max; //���ݵ����ֵ
 private float min; //���ݵ���Сֵ
 private List dataSets = new ArrayList(); //���ݼ�
 private int levelsX; //X��̶���
 private int levelsY; //Y��̶���
 private float spaceX; //X��̶ȼ��
 private float spaceY; //Y��̶ȼ��
 private int unit = 5; //�̶ȼ�Ĳ�
 private int length; //ͼ����Ч�����X�᳤��
 private int downX; //�û�����ǰ���µ�X������
 private int offsetLeft = 50; //ƫ����
 private boolean scrollabled = true; //�Ƿ���Ի���
 private boolean drew = false; //�Ƿ��ѻ�
 private int maxDataSetsLength = -1; //������ݼ����ȣ�-1Ϊ������
 public LineChartView(Context context) {
  super(context);
 }
 public LineChartView(Context context, AttributeSet attrs) {
  super(context, attrs);
 }
 @Override
 protected void onDraw(Canvas canvas) {
  super.onDraw(canvas);
  if (dataSets.isEmpty()) { //������ݼ�Ϊ���򲻽��л���
   if (drew) {
    canvas.drawRect(0, 0, getWidth(), getHeight(), paintClear);
   } else {
    return;
   }
  }
  drew = true; //����ʼ���ƣ������ drew Ϊ true
  init();
  canvas.drawColor(Color.WHITE); //����ɫ
  //����X��̶ȡ����ݵ㡢����
  canvas.drawLine(chartStartX, chartStopY, chartStopX, chartStopY, paintAxis);
  paintAxis.setTextAlign(Align.CENTER);
  int j = (int) Math.ceil(0 - offsetLeft / spaceX) - 1;//�˾���Ϊ����ƿ���ʾ�����ǰ���һ�����ݵ���Ϊ����
  for (int i = 0; i <= levelsx=""> 10 ? 10 : levelsX) + 1; i++, j++) {
   if (j < 0 || j >= dataSets.size()) { //��ֹ�����±�Խ��
    continue;
   }
   DataSet currentPoint = dataSets.get(j);
   float x = getPointX(j);
   canvas.drawLine(x, chartStopY, x, chartStopY + 5, paintAxis);//���ƿ̶�
   canvas.drawText(currentPoint.name, x, chartStopY + 5 + 20, paintAxis);//���ƿ̶�����
   //��������
   float y = getPointY(currentPoint.value);
   if (j + 1 < dataSets.size()) {
    canvas.drawLine(x, y, getPointX(j + 1), getPointY(dataSets.get(j + 1).value), paintLine);
   }
   //�������ݵ�
   canvas.drawCircle(x, y, 5, paintPoint);
  }
  //�ڻ���Y��ǰ����Խ������
  canvas.drawRect(0, 0, chartStartX, getHeight(), paintClear);
  //����Y��̶�
  canvas.drawLine(chartStartX, chartStartY, chartStartX, chartStopY, paintAxis);
  paintAxis.setTextAlign(Align.RIGHT);
  for (int i = 0; i < levelsY; i++) {
   float pointY = chartStopY - (i + 1) * spaceY; //��Y��λ��
   canvas.drawLine(45, pointY, chartStartX, pointY, paintAxis); //���ƿ̶�
   canvas.drawText(String.valueOf((int) min + (i) * unit), 40, pointY + 8, paintAxis); //���ƿ̶�����
  }
  //���Ʊ���
  if (title != null && !title.equals("")) {
   canvas.drawText(title, getWidth() / 2, 30, paintLine);
  }
 }
 /*
  * �������ݵ���Ż��X����ֵ
  */
 private float getPointX(int i) {
  return chartStartX + (i) * spaceX + offsetLeft;
 }
 /*
  * ��������ֵ���Y����ֵ
  */
 private float getPointY(float value) {
  int exceedNum = (int) (Math.ceil(value - min) / unit) + 1; //���㽫Ҫ��Խ�Ŀ̶ȵ���������������ߣ�
  float y = chartStopY - exceedNum * spaceY - (value - min) % unit / unit * spaceY;
  return y;
 }
 public void setScrollable(boolean scrollabled) {
  this.scrollabled = scrollabled;
 }
 /*
  * ���ñ���
  */
 public void setTitle(String title) {
  this.title = title;
  invalidate();
 }
 /*
  * ���ͼ��
  */
 public void empty() {
  dataSets = new ArrayList();
  title = "";
  length = 0;
  invalidate();
 }
 /*
  * ��ʼ����ˢ������������
  */
 private void init() {
  //����ͼ�� 
  chartStartX = 50;
  chartStopX = getWidth();
  chartStartY = 50;
  chartStopY = getHeight() - 30;
  chartWidth = chartStopX - chartStartX;
  chartHeight = chartStopY - chartStartY;
  //���߻�ˢ
  paintAxis.setAntiAlias(true);
  paintAxis.setStrokeWidth(3);
  paintAxis.setColor(Color.parseColor("#858585"));
  paintAxis.setTextSize(18);
  //���ݵ㻭ˢ
  paintPoint.setAntiAlias(true);
  paintPoint.setStrokeWidth(3);
  paintPoint.setStyle(Paint.Style.FILL_AND_STROKE);
  paintPoint.setColor(Color.parseColor("#00aa3a"));
  //���߻�ˢ
  paintLine.setAntiAlias(true);
  paintLine.setStrokeWidth(5);
  paintLine.setTextAlign(Align.CENTER);
  paintLine.setTextSize(35);
  paintLine.setColor(Color.parseColor("#00aa3a"));
  //������ˢ
  paintClear.setColor(Color.WHITE);
  //������ֵ����Сֵ���Ա��ڼ���
  min = max = dataSets.get(0).value;
  for (int i = 1; i < dataSets.size(); i++) {
   DataSet set = dataSets.get(i);
   if (set.value < min) {     min = set.value;    }    if (set.value > max) {
    max = set.value;
   }
  }
  //����X��Y����������Ա����Ժ����
  float minus = max - min;
  unit = (int) Math.ceil(minus / 10);
  unit = unit == 0 ? 1 : unit; //������Ϊ0�Ļ��������Ϊ1����ֹ�̶��޷�����
  levelsY = (int) (Math.ceil((max - min) / unit)); //Y����Ҫ���ƵĿ̶���
  if (levelsY == 0) { //���ֻ��0���̶�ʱ����һֱΪ��ƽ����ʱ����һ���̶ȣ�ʹΨһһ���̶��ܻ������м�
   levelsY++;
  }
  spaceY = chartHeight / (levelsY + 1); //Y��̶ȼ�ľ��룬+1��Ϊ�˸�ǰ�������ռ�
  levelsX = dataSets.size(); //X����Ҫ���ƵĿ̶���
  spaceX = chartWidth / (levelsX > 10 ? 10 : levelsX + 1); //X��̶ȼ�ľ��룬+1��Ϊ�˸�ǰ�������ռ�
  length = (int) (dataSets.size() * spaceX);
 }
 /*
  * ������ݼ�
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
  * �������ײ�
  */
 public void scrollToStart() {
  if (!drew) {
   invalidate();
  }
  offsetLeft = 50;
  invalidate();
 }
 /*
  * ������β��
  */
 public void scrollToEnd() {
  if (!drew) {
   invalidate();
  }
  offsetLeft = chartWidth >= length ? 50 : (0 - (length - chartWidth) - 50);
  invalidate();
 }
 /*
  * �Ƿ��ѹ�����β��
  */
 public boolean isScrolledToStart() {
  return offsetLeft >= 50;
 }
 /*
  * �Ƿ��ѹ������ײ�
  */
 public boolean isScrolledToEnd() {
  return chartWidth >= length ? (offsetLeft <= 50) : (offsetLeft < 0 - (length - chartWidth));
 }
 /*
  * �������ݼ�
  */
 public void setDataSets(List dataSets) {
  length = 0;
  this.dataSets = dataSets;
  invalidate();
  scrollToEnd();
 }
 /*
  * ����ʱ�䣬����û��Ƿ񻬶�
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
   //distanceX<0Ϊ��ָ���󻬶���distancex>0Ϊ��ָ���һ���
   int distanceX = (int) event.getRawX() - downX;//�ƶ��ľ���
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
���ǿ����ڲ���������ʹ�ã�

<hk.jerry.linechart.LineChartView
 android:id="@+id/lc_test"
 android:layout_width="match_parent"
 android:layout_height="match_parent"/>
Ȼ��������ݣ�
LineChartView lcHistory = (LineChartView) findViewById(R.id.lc_test);
//�������� lcHistory.setTitle("����ͼ��");
Random random = new Random(10);
for (i = 0; i < 50; i++) {
    lcHistory.addDataSet(new DataSet((50 - i) + "����ǰ", random.nextInt(40)));
}