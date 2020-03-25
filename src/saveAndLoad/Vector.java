package saveAndLoad;

public class Vector {
	private Object[] _array;
	public Vector() {
		_array = new Object[0];
	}
	public void add(Object object) {
		Object[] temp = new Object[_array.length + 1];
		for(int i = 0; i < _array.length; i++) {
			temp[i] = _array[i];
		}
		temp[_array.length] = object;
		_array = new Object[temp.length];
		for(int i = 0; i < _array.length; i++) {
			_array[i] = temp[i];
		}
	}
	public Object get(int num) {
		return _array[num];
	}
	public void remove(int num) {
		Object[] temp = new Object[_array.length - 1];
		for(int i = 0; i < num; i++) {
			temp[i] = _array[i];
		}
		for(int i = num + 1; i < _array.length; i++) {
			temp[i] = _array[i];
		}
		_array = new Object[temp.length];
		for(int i = 0; i < _array.length; i++) {
			_array[i] = temp[i];
		}
	}
	public void remove(Object object) {
		int num = 0;
		Object[] temp = new Object[_array.length - 1];
		for(int i = 0; i < _array.length; i++) {
			if(_array[i].equals(object)) {
				num = i;
				break;
			}
			temp[i] = _array[i];
		}
		for(int i = num + 1; i < _array.length; i++) {
			temp[i] = _array[i];
		}
		_array = new Object[temp.length];
		for(int i = 0; i < _array.length; i++) {
			_array[i] = temp[i];
		}
		
	}
	public int getSize() {
		return _array.length;
	}
}