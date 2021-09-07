package deghat.farhad.common.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class UseCase<T, P>(
    private val coroutineContext: CoroutineContext
) {
    abstract suspend fun buildUseCase(params: P): ModelWrapper<T>

    fun execute(uiScheduler: CoroutineScope, params: P, onResult: (ModelWrapper<T>) -> Unit = {}) {
        uiScheduler.launch(coroutineContext) {
            onResult(buildUseCase(params))
        }
    }
}