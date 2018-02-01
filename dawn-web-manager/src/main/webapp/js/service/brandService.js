//品牌服务层
app.service('brandService',function($http){

//抽取查询方法
    this.findAll=function(){
        return $http.get('../brand/findAll.do');//业务逻辑层 service
    }

    //抽取删除的方法
    this.delete=function(ids){
        return $http.get('../brand/delete.do?ids='+ids);
    }
    //抽取添加的方法
    this.add=function(entity){
        return $http.post('../brand/add.do',entity)
    }
    //抽取修改的方法
    this.update=function(entity){
        return $http.post('../brand/update.do',entity)
    }
    //抽取根据id查询
    this.findOne=function(id){
        return $http.get('../brand/findOne.do?id='+id);
    }
    //抽取条件查询分页方法
    this.search=function(page,rows,searchEntity){
        return $http.post('../brand/search.do?page='+page+"&rows="+rows,searchEntity);
    }
    //抽取分页方法
    this.findPage=function(page,rows){
        return $http.get('../brand/findPage.do?page='+ page + '&rows=' + rows);
    }

    //下拉列表数据
    this.selectOptionList=function(){
        return  $http.get('../brand/selectOptionList.do');
    }

});