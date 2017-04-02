//package string;
//
//import com.google.common.io.Files;
//import org.junit.Test;
//import org.mozilla.universalchardet.UniversalDetector;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.nio.charset.Charset;
//
//
//public class CharSetTransfer {
//
//	@Test
//	public void test1() throws Exception {
//		File root = new File("/Users/wanggen/workspace/tap-manager");
//		visitFile(root);
//	}
//
//
//	public void visitFile(File file) throws Exception {
//		String name = file.getName();
//		if (name.equals(".idea") || name.equals(".git"))
//			return;
//		if (file.isDirectory()) {
//			for (File file1 : file.listFiles()) {
//				visitFile(file1);
//			}
//		} else {
//
//			if (name.endsWith(".java")
//							|| name.endsWith(".vm")
//							|| name.endsWith("xml")
//							|| name.endsWith(".properties")
//							) {
//				UniversalDetector detector        = new UniversalDetector(null);
//				int               nread;
//				FileInputStream   fileInputStream = new FileInputStream(file);
//				byte[]            buf             = new byte[256];
//				while ((nread = fileInputStream.read(buf)) > 0 && !detector.isDone()) {
//					detector.handleData(buf, 0, nread);
//				}
//				detector.dataEnd();
//				String encoding = detector.getDetectedCharset();
//				if (encoding != null) {
//					System.out.println("" + encoding + "   " + file);
//
//					String fileStr = Files.toString(file, Charset.forName(encoding));
////					System.out.println(fileStr);
//
//					Files.write(fileStr, file, Charset.forName("UTF-8"));
//
//				} else {
//					System.err.println("No encoding detected. " + file);
//				}
//				detector.reset();
//				fileInputStream.close();
//
//			}
//
//		}
//	}
//
//
//}
