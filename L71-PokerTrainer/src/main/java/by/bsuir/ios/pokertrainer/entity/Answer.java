package by.bsuir.ios.pokertrainer.entity;

public class Answer {

	private int answerId;
	private int questionId;
	private String text;
	private boolean isTrue;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + answerId;
		result = prime * result + (isTrue ? 1231 : 1237);
		result = prime * result + questionId;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (answerId != other.answerId)
			return false;
		if (isTrue != other.isTrue)
			return false;
		if (questionId != other.questionId)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Answer [answerId=");
		builder.append(answerId);
		builder.append(", questionId=");
		builder.append(questionId);
		builder.append(", text=");
		builder.append(text);
		builder.append(", isTrue=");
		builder.append(isTrue);
		builder.append("]");
		return builder.toString();
	}

}
