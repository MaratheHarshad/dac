package generic;

//generic class T : Type
public class Holder<T> {
	// generic class is a class with type parameter
 
	private T ref;

	public Holder(T ref) {
		super();
		this.ref = ref;
	}

	public T getRef() {
		return ref;
	}
}
