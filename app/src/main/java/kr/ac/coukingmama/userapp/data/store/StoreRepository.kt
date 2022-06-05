package kr.ac.coukingmama.userapp.data.cafe

import androidx.lifecycle.LiveData

class CafeRepository(private val postDao: CafeDAO)  {
    val readAllPost: LiveData<List<Cafe>> = postDao.getAll()
    val getCount: LiveData<Int>? = postDao.getCount()

    suspend fun addPost(post:Cafe){
        postDao.insert(post)
    }

    fun deletePost(id:Int){
        postDao.deleteById(id)
    }

    suspend fun updatePost(post:Cafe){
        postDao.update(post)
    }



}