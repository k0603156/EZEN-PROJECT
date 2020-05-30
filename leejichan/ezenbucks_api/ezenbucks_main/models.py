from django.db import models


class Product(models.Model):
    product_name = models.CharField(null=True, blank=True, max_length=100)
    unit_price = models.IntegerField(null=True, blank=True)
    product_species = models.CharField(null=True, blank=True, max_length=50)


class Customer(models.Model):
    customer_name = models.CharField(max_length=50, null=True, blank=True)


class Shop(models.Model):
    name = models.CharField(max_length=50, null=True, blank=True)


class Order(models.Model):
    customer = models.ForeignKey(Customer, on_delete=models.CASCADE, null=True, blank=True)
    order_status = models.CharField(max_length=50, null=True, blank=True)
    order_date = models.DateTimeField(null=True, blank=True)
    shop = models.ForeignKey(Shop, on_delete=models.CASCADE, null=True, blank=True)

    @property
    def products(self):
        return OrderProduct.objects.filter(order=self).order_by('id')


class OrderProduct(models.Model):
    PRODUCT_TEMP_CHOICES = (
        ('HOT', 'HOT'),
        ('ICE', 'ICE'),
        ('NONE', 'NONE')
    )

    PRODUCT_SIZE_CHOICES = (
        ('short', 'SHORT'),
        ('tall', 'TALL'),
        ('grande', 'GRANDE'),
        ('venti', 'VENTI')
    )

    order = models.ForeignKey(Order, on_delete=models.CASCADE, null=True, blank=True)
    product = models.ForeignKey(Product, on_delete=models.CASCADE, null=True, blank=True)
    quantity = models.IntegerField(null=True, blank=True)
    product_temp = models.CharField(max_length=10, choices=PRODUCT_TEMP_CHOICES, null=True, blank=True)
    product_size = models.CharField(max_length=10, choices=PRODUCT_SIZE_CHOICES, null=True, blank=True)
