package readtable;

import javax.swing.table.AbstractTableModel;
class MyDataModel extends AbstractTableModel{
  Integer[][] array=new Integer[4][3]; //�����, � ����� ����������� ���, �� ������ ���� � �������
  public MyDataModel(){
    for (int i=0;i<3;i++)
      for (int j=0;j<3;j++)
        array[i][j]=new Integer(0);
  }
  public int getColumnCount() {return 4;}//� ������� 3 ���������
  public int getRowCount() {return 3;} //� ������� 3 �����
  public boolean isCellEditable(int row, int column) { //�� ����� ���������� �������� � ������� �������
  return true;
  }
  public Object getValueAt(int row,int col) { //���, �� ������������� � �������
    return array[row][col];
  }
  public void setValueAt(Object value,int row,int col){ //���, �� ����������� � �������
    array[row][col]=new Integer((String)value);
  }
}
