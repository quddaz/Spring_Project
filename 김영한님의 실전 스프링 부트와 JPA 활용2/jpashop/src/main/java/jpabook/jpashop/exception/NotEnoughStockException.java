package jpabook.jpashop.exception;
//사용자 정의 오류 지정
public class NotEnoughStockException extends RuntimeException{
  public NotEnoughStockException() {
  }
  public NotEnoughStockException(String message) {
    super(message);
  }
  public NotEnoughStockException(String message, Throwable cause) {
    super(message, cause);
  }
}
