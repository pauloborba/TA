package taL

class Evaluation {
	public String title
	public List<Question> questions

	static constraints = {
        title blank: false
    }

	public String getTitle() { title }

	public Question getQuestion(int index) { questions[index] }
}