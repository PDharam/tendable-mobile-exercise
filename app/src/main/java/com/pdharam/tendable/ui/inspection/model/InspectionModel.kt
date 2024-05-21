package com.pdharam.tendable.ui.inspection.model

data class InspectionModel(
    val inspection: Inspection
)

data class Inspection(
    val area: Area,
    val id: Int,
    val inspectionType: InspectionType,
    val survey: Survey
)

data class Area(
    val id: Int,
    val name: String
)

data class InspectionType(
    val access: String,
    val id: Int,
    val name: String
)

data class Survey(
    val categories: List<Category>,
    val id: Int
)

data class Category(
    val id: Int,
    val name: String,
    val questions: List<Question>
)

data class Question(
    val answerChoices: List<AnswerChoice>,
    val id: Int,
    val name: String,
    val selectedAnswerChoiceId: Any
)

data class AnswerChoice(
    val id: Int,
    val name: String,
    val score: Double
)