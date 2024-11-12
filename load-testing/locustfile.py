import time
from locust import HttpUser, task, between,TaskSet

class TareasTesting(HttpUser):
    wait_time = between(5, 15)
  
    @task(1)
    def index(self):
        self.client.get("/",name="index")

    @task(2)
    def ping(self):
        self.client.get("/api/v1/ping/kyndryl.com",name="/ping/kyndryl.com")

    @task(4)
    def product(self):
        self.client.get("/api/v1/product",name="/productList")
    
    @task(5)
    def products(self):
       for item_id in range(7):
            self.client.get(f"/api/v1/product/id/{item_id}", name="/productId")
            time.sleep(1)
    