package skuniv.sc.yeju.middlePjt.LibraySystem;

import java.io.IOException;

public interface RentalBean {
	void rental(String name)throws IOException;
	void changeState(String filename, String bookname, String original, String replace) throws IOException;
}
